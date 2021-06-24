package com.example.service;

import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.example.entity.EnterpriseInfo;
import com.example.entity.Header;
import com.example.mapper.EnterpriseInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用人单位信息 服务类
 *
 * @author dragon
 * @date 2021/6/24
 */
@Service
public class EnterpriseInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(EnterpriseInfoService.class);

    private static final TemplateEngine ENGINE = TemplateUtil.createEngine(new TemplateConfig("freemarker",
            TemplateConfig.ResourceMode.CLASSPATH));


    @Resource
    private EnterpriseInfoMapper enterpriseInfoMapper;

    /**
     * 生成 用人单位信息 xml文档
     *
     * @param header             头部信息
     * @param enterpriseInfoList 用人单位信息集合
     * @return xml文档
     */
    public String generateEnterpriseInfoXml(Header header, List<EnterpriseInfo> enterpriseInfoList) {
        Template template = ENGINE.getTemplate("/employerInfo.ftl");

        Dict dict = Dict.create();
        dict.put("header", header);
        dict.put("enterpriseInfoList", enterpriseInfoList);

        return template.render(dict);
    }

    /**
     * 查询所有的用人单位信息
     *
     * @return
     */
    public List<EnterpriseInfo> list() {
        try {
            return enterpriseInfoMapper.list();
        } catch (Exception e) {
            LOG.error("用人单位信息查询出错", e);
            throw e;
        }
    }
}
