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
import java.util.stream.Collectors;


/**
 * @author dragon
 * @date 2021/6/25
 */
@Service
public class HealthExamRecordService {

    private static final Logger LOG = LoggerFactory.getLogger(EnterpriseInfoService.class);

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
                        throw new RuntimeException("查询健康档案信息中,工作者信息中体检号为空");
                    }
                    List<ExamConclusion> examConclusions = mapper.listExamConclusion();
                    if (CollUtil.isNotEmpty(examConclusions)) {
                        examConclusions = examConclusions.stream()
                                .filter(examConclusion -> tjh000.equals(examConclusion.getTjh000()))
                                .collect(Collectors.toList());

                        healthExamRecord.setExamConclusionList(examConclusions);
                    }
                    List<ExamItemResult> examItemResults = mapper.listExamItemResult();
                    if (CollUtil.isNotEmpty(examItemResults)) {
                        examItemResults = examItemResults.stream()
                                .filter(examItemResult -> tjh000.equals(examItemResult.getTjh000()))
                                .collect(Collectors.toList());

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
