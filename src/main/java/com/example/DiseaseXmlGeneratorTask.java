package com.example;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.example.entity.EnterpriseInfo;
import com.example.entity.Header;
import com.example.entity.HealthExamRecord;
import com.example.entity.HospitalXmlFile;
import com.example.enums.BusinessActivityType;
import com.example.enums.OperateType;
import com.example.service.EnterpriseInfoService;
import com.example.service.HospitalXmlFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 河南省职工医院 职业病接口
 *
 * @author dragon
 * @date 2021/6/22
 */
@Component
public class DiseaseXmlGeneratorTask {

    private static final Logger LOG = LoggerFactory.getLogger(DiseaseXmlGeneratorTask.class);

    @Resource
    private EnterpriseInfoService enterpriseInfoService;

    @Resource
    private HospitalXmlFileService hospitalXmlFileService;

    private static final TemplateEngine ENGINE = TemplateUtil.createEngine(new TemplateConfig("freemarker",
            TemplateConfig.ResourceMode.CLASSPATH));


    /**
     * 查询 生成 保存
     */
    public void generateEnterpriseInfoXml() throws FileNotFoundException {
        List<EnterpriseInfo> list = enterpriseInfoService.list();
        if (CollUtil.isEmpty(list)) {
            LOG.warn("通过视图查询出来的[用人单位信息为空]");
            return;
        }
        list.stream()
                .filter(Objects::nonNull)
                .forEach(enterpriseInfo -> {
                    Field[] declaredFields = ClassUtil.getDeclaredFields(enterpriseInfo.getClass());
                    for (Field declaredField : declaredFields) {
                        declaredField.setAccessible(true);
                        if (declaredField.getType().isAssignableFrom(String.class)) {
                            try {
                                declaredField.set(enterpriseInfo, StrUtil.trim((String) declaredField.get(enterpriseInfo)));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

        Header header = new Header();
        // todo dragon 2021/6/24 神火山医院机构编码
        String orgCode = "机构编码";
        String businessActivityType = BusinessActivityType.ENTERPRISE_INFO.name();
        String currentDate = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATETIME_MS_PATTERN);
        String randomNum = RandomUtil.randomNumbers(5);
        header.setDocumentId(orgCode + "-" + businessActivityType + "-" + currentDate + "-" + randomNum);

        header.setOperateType(OperateType.Add);

        header.setBusinessActivityIdentification("NEWOMAR");

        // todo dragon 2021/6/24 上报机构代码
        header.setReportOrgCode("上报机构代码");

        // todo dragon 2021/6/24 上报地区代码
        header.setReportZoneCode("上报地区代码");

        // todo dragon 2021/6/24 上报机构授权码
        header.setLicense("上报机构授权码");

        String content = enterpriseInfoService.generateEnterpriseInfoXml(header, list);

        IoUtil.writeUtf8(new FileOutputStream("employerInfo.xml"), true, content);

        HospitalXmlFile hospitalXmlFile = new HospitalXmlFile();
        hospitalXmlFile.setHospitalCode("410040");
        hospitalXmlFile.setContent(content);
        hospitalXmlFile.setType(0);

        HospitalXmlFile hospitalXmlFileDb = hospitalXmlFileService.get("410040", 0);

        if (hospitalXmlFileDb != null) {
            hospitalXmlFileDb.setContent(content);
            hospitalXmlFileService.update("410040", 0, content);
        } else {
            hospitalXmlFileService.save(hospitalXmlFile);
        }
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
