package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.example.entity.ExamConclusion;
import com.example.entity.ExamItemResult;
import com.example.entity.Header;
import com.example.entity.HealthExamRecord;
import com.example.mapper.HealthExamRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


/**
 * @author dragon
 * @date 2021/6/25
 */
@Service
public class HealthExamRecordService {

    private static final Logger LOG = LoggerFactory.getLogger(HealthExamRecordService.class);

    private static final TemplateEngine ENGINE = TemplateUtil.createEngine(new TemplateConfig("freemarker",
            TemplateConfig.ResourceMode.CLASSPATH));


    @Resource
    private HealthExamRecordMapper mapper;

    public List<HealthExamRecord> list() {
        List<HealthExamRecord> list = mapper.list();
        if (CollUtil.isEmpty(list)) {
            return null;
        }
        list.stream()
                .filter(Objects::nonNull)
                .forEach(healthExamRecord -> {
                    String tjh000 = healthExamRecord.getTjh000();
                    if (StrUtil.isEmpty(tjh000)) {
                        LOG.info("查询体检结论开始");
                        List<ExamConclusion> examConclusions = mapper.listExamConclusion(tjh000);
                        LOG.info("查询体检结论结束");
                        healthExamRecord.setExamConclusionList(examConclusions);

                        LOG.info("查询检查项目开始");
                        List<ExamItemResult> examItemResults = mapper.listExamItemResult(tjh000);
                        LOG.info("查询检查项目结束");
                        healthExamRecord.setExamItemResultList(examItemResults);
                    }
                });

        return list;
    }

    /**
     * 生成 健康档案 xml文档
     *
     * @param header               头部信息
     * @param healthExamRecordList 健康档案信息集合
     * @return 健康档案xml文档
     */
    public String generateHealthArchiveXml(Header header, List<HealthExamRecord> healthExamRecordList) {
        Template template = ENGINE.getTemplate("/healthArchive.ftl");
        Dict dict = Dict.create();

        dict.put("header", header);
        dict.put("healthExamRecordList", healthExamRecordList);

        return template.render(dict);
    }
}
