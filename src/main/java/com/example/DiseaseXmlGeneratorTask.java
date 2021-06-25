package com.example;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.example.entity.EnterpriseInfo;
import com.example.entity.Header;
import com.example.entity.HealthExamRecord;
import com.example.entity.HospitalXmlFile;
import com.example.enums.BusinessActivityType;
import com.example.enums.OperateType;
import com.example.service.EnterpriseInfoService;
import com.example.service.HealthExamRecordService;
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
    private HealthExamRecordService examRecordService;

    @Resource
    private HospitalXmlFileService hospitalXmlFileService;

    /**
     * 用人单位信息
     */
//   @Scheduled(cron = "* * 0/1 * * ?")
    public void generateEnterpriseInfoXml() throws FileNotFoundException {
        LOG.info("用人单位信息接口开始运行");
        List<EnterpriseInfo> list = enterpriseInfoService.list();
        if (CollUtil.isEmpty(list)) {
            LOG.error("通过视图查询出来的[用人单位信息为空]");
            return;
        }
        trimFiled(list);
        LOG.info("查询到的用人单位信息: {}", list);

        Header header = buildHeader(BusinessActivityType.ENTERPRISE_INFO, OperateType.Add);

        LOG.info("头部信息: {}", header);

        String content = enterpriseInfoService.generateEnterpriseInfoXml(header, list);

        saveXml("employerInfo.xml", content, "410040", 0);
    }

    /**
     * 健康档案信息
     *
     * @throws FileNotFoundException
     */
//    @Scheduled(cron = "* * 0/1 * * ?")
    public void generateHealthExamRecordXml() throws FileNotFoundException {
        LOG.info("健康档案信息信息接口开始运行");
        List<HealthExamRecord> list = examRecordService.list();
        if (CollUtil.isEmpty(list)) {
            LOG.error("通过视图查询出来的[健康档案为空]");
        }
        trimFiled(list);
        LOG.info("查询到的健康档案信息: {}", list);

        Header header = buildHeader(BusinessActivityType.HEALTH_EXAM_RECORD, OperateType.Add);
        LOG.info("头部信息: {}", header);
        String content = examRecordService.generateHealthArchiveXml(header, list);

        saveXml("healthExamRecord.xml", content, "410040", 1);

    }

    private void trimFiled(List<?> list) {
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
    }

    private Header buildHeader(BusinessActivityType activityType, OperateType operateType) {
        Header header = new Header();
        // todo dragon 2021/6/24 神火山医院机构编码
        String orgCode = "机构编码";
        String businessActivityType = activityType.name();
        String currentDate = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATETIME_MS_PATTERN);
        String randomNum = RandomUtil.randomNumbers(5);
        header.setDocumentId(orgCode + "-" + businessActivityType + "-" + currentDate + "-" + randomNum);

        header.setOperateType(operateType);

        header.setBusinessActivityIdentification("NEWOMAR");

        // todo dragon 2021/6/24 上报机构代码
        header.setReportOrgCode("上报机构代码");

        // todo dragon 2021/6/24 上报地区代码
        header.setReportZoneCode("上报地区代码");

        // todo dragon 2021/6/24 上报机构授权码
        header.setLicense("上报机构授权码");

        return header;
    }

    private void saveXml(String fileName, String content, String hospitalCode, Integer type) throws FileNotFoundException {
        IoUtil.writeUtf8(new FileOutputStream(fileName), true, content);

        HospitalXmlFile hospitalXmlFile = new HospitalXmlFile();
        hospitalXmlFile.setHospitalCode(hospitalCode);
        hospitalXmlFile.setContent(content);
        hospitalXmlFile.setType(type);

        HospitalXmlFile hospitalXmlFileDb = hospitalXmlFileService.get(hospitalCode, type);

        if (hospitalXmlFileDb != null) {
            hospitalXmlFileDb.setContent(content);
            hospitalXmlFileService.update(hospitalCode, type, content);
            LOG.info("医院编码:[{}]更新type=[{}]的xml文件,文件内容:[{}]", hospitalCode, type, content);
        } else {
            hospitalXmlFileService.save(hospitalXmlFile);
            LOG.info("医院编码:[{}]新增type=[{}]的xml文件,文件内容:[{}]", hospitalCode, type, content);
        }
    }


}
