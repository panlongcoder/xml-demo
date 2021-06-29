package com.example.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 职业健康档案
 *
 * @author dragon
 * @date 2021/6/22
 */
public class HealthExamRecord implements Serializable {

    private static final long serialVersionUID = 7920948990951119722L;

    @NotNull(message = "团检团体id不能为空")
    private String id;

    @NotBlank(message = "用人单位名称不能为空")
    private String enterpriseName;

    @NotBlank(message = "统一社会信用代码不能为空")
    private String creditCode;


    /**
     * 企业类型代码(条件必填)
     * <p>
     * 当行业类别为 公共管理、社会保障和社会组织;国际组织时，该项非必填 (GB/T12402-2000 经济类型 分类与代码)
     */
    private String economicTypeCode;

    /**
     * GB/T4754- 2017 国民经济 行业分类
     */
    @NotBlank(message = "行业类别代码不能为空")
    private String industryCategoryCode;

    /**
     * 企业规模代码(条件必填)
     * 当行业类别为 公共管理、社会保障和社会组织;国际组 织时，该项非 必填 参见数据元值 域代码表:企 业规模代码表
     */
    private String businessScaleCode;

    /**
     * 参见数据元值 域代码表:地区/机构代码表
     */
    @NotBlank(message = "所属地区代码不能为空")
    private String addressCode;

    /**
     * 企业地址详情
     */
    @NotBlank(message = "企业地址详情不能为空")
    private String addressDetail;


    /**
     * 邮政代码
     */
    private String addressZipCode;

    /**
     * 单位联系人
     */
    @NotBlank(message = "单位联系人不能为空")
    private String enterpriseContact;

    /**
     * 单位联系人电话
     */
    @NotBlank(message = "单位联系人电话不能为空")
    private String contactTelephone;


    /**
     * 用人单位所在区全名称
     */
    private String allName;

    /**
     * 用工单位名称
     * 当行业类别为 人力资源服务 (726)及其子 类别时，该项不 能和用人单位 名称相同
     */
    @NotBlank(message = "用工单位名称不能为空")
    private String enterpriseNameEmployer;

    /**
     * 用工单位统一社会信用代码(18 位)
     */
    @NotBlank(message = "用工单位统一社会信用代码不能为空")
    private String creditCodeEmployer;

    /**
     * 用工单位企业类型代码
     * <p>
     * 当行业类别为 公共管理、社会 保障和社会组 织;国际组织 时，该项非必填 GB/T12402-200 0 经济类型分类 与代码
     */
    private String economicTypeCodeEmployer;

    /**
     * 用工单位行业类别代码
     * GB/T4754-2017国民经济行业 分类
     */
    @NotBlank(message = "用工单位行业类别代码不能为空")
    private String industryCategoryCodeEmployer;

    /**
     * 用工单位企业规模代码
     */
    @NotBlank(message = "用工单位企业规模代码不能为空")
    private String businessScaleCodeEmployer;

    /**
     * 用工单位所属地区代码
     * <p>
     * 参见数据元值 域代码表:地区 /机构代码表
     */
    @NotBlank(message = "用工单位所属地区代码不能为空")
    private String addressCodeEmployer;

    /**
     * 用工单位所在区全名称(如:北京市市辖区海淀区)
     */
    @NotBlank(message = "用工单位所在区全名称不能为空")
    private String allNameEmployer;


    /**
     * 体检号
     */
    @NotBlank(message = "体检号不能为空")
    private String tjh000;
    /**
     * 姓名
     */
    @NotBlank(message = "劳动者姓名不能为空")
    private String workName;

    /**
     * 身份证件类型代 码
     * WS364.3 卫生信 息数据元值域代码，CV02.01.101 身份证件类别代 码表
     */
    @NotBlank(message = "身份证件类型代码不能为空")
    private String idCardTypeCode;

    @NotBlank(message = "身份证件号码不能为空")
    private String idCard;

    /**
     * GB/T2261.1- 2003
     */
    @NotBlank(message = "性别代码不能为空")
    private String genderCode;

    /**
     * 日期格式 yyyyMMdd
     */
    @NotBlank(message = "出生日期不能为空")
    private String birthDate;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空")
    private String workerTelephone;

    /**
     * 监测类型代码
     * <p>
     * 01 常规监测、 02 主动监测、 03 其他监测
     */
    @NotBlank(message = "监测类型代码不能为空")
    private String jcType;

    /**
     * 检查类型代码
     * 参见数据元值域 代码表:检查类 型代码表
     */
    @NotBlank(message = "检查类型代码不能为空")
    private String examTypeCode;

    /**
     * 体检日期
     */
    @NotBlank(message = "体检日期不能为空")
    private String examDate;

    /**
     * 接触的职业病危害因素代码
     */
    @NotBlank(message = "接触的职业病危害因素代码不能为空")
    private String contactFactorCode;

    /**
     * 接触的其他职业病危害因素
     * <p>
     * 接触的危害因素选择其他时，该项必填
     */
    private String contactFactorOther;

    /**
     * 体检危害因素代码
     * <p>
     * 参见数据元值域代码表:职业病危害因素代码表
     */
    @NotBlank(message = "体检危害因素代码不能为空")
    private String factorCode;

    /**
     * 其他危害因素具体名称
     * <p>
     * 危害因素选择其他时，该项必填
     */
    private String factorOther;

    /**
     * 工种代码
     * 参见数据元值域代码表:工种代码表
     */
    @NotBlank(message = "填表人电话不能为空")
    private String workTypeCode;
    /**
     * 其他工种名称(工种选择其他时，需要在这里保存具体工种的名字)
     * <p>
     * 工种选择其他 时，该项必填
     */
    private String otherWorkType;

    /**
     * 是否复查(见字典是否复查) T/F
     */
    private String isReview;
    /**
     * 创建地区代码
     * 参见数据元值域 代码表:地区/机 构代码表
     */
    @NotBlank(message = "创建地区代码不能为空")
    private String areaCode;
    /**
     * 创建机构代码
     * 参见数据元值域 代码表:地区/机 构代码表
     */
    @NotBlank(message = "创建机构代码不能为空")
    private String orgCode;

    /**
     * 体检结论集合
     */
    private List<ExamConclusion> examConclusionList;


    /**
     * 检查项目信息集合
     */
    private List<ExamItemResult> examItemResultList;


    @NotBlank(message = "填表人姓名不能为空")
    private String writePerson;

    @NotBlank(message = "填表单位名称不能为空")
    private String writeUnit;


    @NotBlank(message = "填表人联系电话不能为空")
    private String writePersonTelephone;

    /**
     * 填表日期
     */
    @NotBlank(message = "填表日期不能为空")
    private String writeDate;

    /**
     * 填表单位名称
     */
    @NotBlank(message = "填表单位名称不能为空")
    private String reportOrganCreditCode;

    /**
     * 报告人姓名
     */
    @NotBlank(message = "报告人姓名不能为空")
    private String reportPerson;
    /**
     * 报告人联系电话
     */
    @NotBlank(message = "报告人联系电话不能为空")
    private String reportPersonTel;
    /**
     * 报告日期
     */
    @NotBlank(message = "报告日期不能为空")
    private String reportDate;

    /**
     * 报告单位名称
     */
    @NotBlank(message = "报告单位名称不能为空")
    private String reportUnit;
    /**
     * 备注
     */
    private String remark;

    /**
     * 审核状态
     * 参见数据元值 域代码表:审 核状态代码表
     */
    @NotBlank(message = "审核状态不能为空")
    private String auditStatus;

    /**
     * 审核意见
     */
    @NotBlank(message = "审核意见不能为空")
    private String auditInfo;

    /**
     * 审核时间
     */
    @NotBlank(message = "审核时间不能为空")
    private String auditDate;

    /**
     * 审核人姓名
     */
    @NotBlank(message = "审核人姓名不能为空")
    private String auditorName;

    /**
     * 审核机构
     */
    @NotBlank(message = "审核机构不能为空")
    private String auditOrg;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getEconomicTypeCode() {
        return economicTypeCode;
    }

    public void setEconomicTypeCode(String economicTypeCode) {
        this.economicTypeCode = economicTypeCode;
    }

    public String getIndustryCategoryCode() {
        return industryCategoryCode;
    }

    public void setIndustryCategoryCode(String industryCategoryCode) {
        this.industryCategoryCode = industryCategoryCode;
    }

    public String getBusinessScaleCode() {
        return businessScaleCode;
    }

    public void setBusinessScaleCode(String businessScaleCode) {
        this.businessScaleCode = businessScaleCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getEnterpriseContact() {
        return enterpriseContact;
    }

    public void setEnterpriseContact(String enterpriseContact) {
        this.enterpriseContact = enterpriseContact;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getAllName() {
        return allName;
    }

    public void setAllName(String allName) {
        this.allName = allName;
    }

    public String getEnterpriseNameEmployer() {
        return enterpriseNameEmployer;
    }

    public void setEnterpriseNameEmployer(String enterpriseNameEmployer) {
        this.enterpriseNameEmployer = enterpriseNameEmployer;
    }

    public String getCreditCodeEmployer() {
        return creditCodeEmployer;
    }

    public void setCreditCodeEmployer(String creditCodeEmployer) {
        this.creditCodeEmployer = creditCodeEmployer;
    }

    public String getEconomicTypeCodeEmployer() {
        return economicTypeCodeEmployer;
    }

    public void setEconomicTypeCodeEmployer(String economicTypeCodeEmployer) {
        this.economicTypeCodeEmployer = economicTypeCodeEmployer;
    }

    public String getIndustryCategoryCodeEmployer() {
        return industryCategoryCodeEmployer;
    }

    public void setIndustryCategoryCodeEmployer(String industryCategoryCodeEmployer) {
        this.industryCategoryCodeEmployer = industryCategoryCodeEmployer;
    }

    public String getBusinessScaleCodeEmployer() {
        return businessScaleCodeEmployer;
    }

    public void setBusinessScaleCodeEmployer(String businessScaleCodeEmployer) {
        this.businessScaleCodeEmployer = businessScaleCodeEmployer;
    }

    public String getAddressCodeEmployer() {
        return addressCodeEmployer;
    }

    public void setAddressCodeEmployer(String addressCodeEmployer) {
        this.addressCodeEmployer = addressCodeEmployer;
    }

    public String getAllNameEmployer() {
        return allNameEmployer;
    }

    public void setAllNameEmployer(String allNameEmployer) {
        this.allNameEmployer = allNameEmployer;
    }

    public String getTjh000() {
        return tjh000;
    }

    public void setTjh000(String tjh000) {
        this.tjh000 = tjh000;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getIdCardTypeCode() {
        return idCardTypeCode;
    }

    public void setIdCardTypeCode(String idCardTypeCode) {
        this.idCardTypeCode = idCardTypeCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getWorkerTelephone() {
        return workerTelephone;
    }

    public void setWorkerTelephone(String workerTelephone) {
        this.workerTelephone = workerTelephone;
    }

    public String getJcType() {
        return jcType;
    }

    public void setJcType(String jcType) {
        this.jcType = jcType;
    }

    public String getExamTypeCode() {
        return examTypeCode;
    }

    public void setExamTypeCode(String examTypeCode) {
        this.examTypeCode = examTypeCode;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getContactFactorCode() {
        return contactFactorCode;
    }

    public void setContactFactorCode(String contactFactorCode) {
        this.contactFactorCode = contactFactorCode;
    }

    public String getContactFactorOther() {
        return contactFactorOther;
    }

    public void setContactFactorOther(String contactFactorOther) {
        this.contactFactorOther = contactFactorOther;
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }

    public String getFactorOther() {
        return factorOther;
    }

    public void setFactorOther(String factorOther) {
        this.factorOther = factorOther;
    }

    public String getWorkTypeCode() {
        return workTypeCode;
    }

    public void setWorkTypeCode(String workTypeCode) {
        this.workTypeCode = workTypeCode;
    }

    public String getOtherWorkType() {
        return otherWorkType;
    }

    public void setOtherWorkType(String otherWorkType) {
        this.otherWorkType = otherWorkType;
    }

    public String getIsReview() {
        return isReview;
    }

    public void setIsReview(String isReview) {
        this.isReview = isReview;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public List<ExamConclusion> getExamConclusionList() {
        return examConclusionList;
    }

    public void setExamConclusionList(List<ExamConclusion> examConclusionList) {
        this.examConclusionList = examConclusionList;
    }

    public List<ExamItemResult> getExamItemResultList() {
        return examItemResultList;
    }

    public void setExamItemResultList(List<ExamItemResult> examItemResultList) {
        this.examItemResultList = examItemResultList;
    }

    public String getWritePerson() {
        return writePerson;
    }

    public void setWritePerson(String writePerson) {
        this.writePerson = writePerson;
    }

    public String getWriteUnit() {
        return writeUnit;
    }

    public void setWriteUnit(String writeUnit) {
        this.writeUnit = writeUnit;
    }

    public String getWritePersonTelephone() {
        return writePersonTelephone;
    }

    public void setWritePersonTelephone(String writePersonTelephone) {
        this.writePersonTelephone = writePersonTelephone;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getReportOrganCreditCode() {
        return reportOrganCreditCode;
    }

    public void setReportOrganCreditCode(String reportOrganCreditCode) {
        this.reportOrganCreditCode = reportOrganCreditCode;
    }

    public String getReportPerson() {
        return reportPerson;
    }

    public void setReportPerson(String reportPerson) {
        this.reportPerson = reportPerson;
    }

    public String getReportPersonTel() {
        return reportPersonTel;
    }

    public void setReportPersonTel(String reportPersonTel) {
        this.reportPersonTel = reportPersonTel;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditOrg() {
        return auditOrg;
    }

    public void setAuditOrg(String auditOrg) {
        this.auditOrg = auditOrg;
    }

    @Override
    public String toString() {
        return "HealthExamRecord{" +
                "id='" + id + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", economicTypeCode='" + economicTypeCode + '\'' +
                ", industryCategoryCode='" + industryCategoryCode + '\'' +
                ", businessScaleCode='" + businessScaleCode + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", addressZipCode='" + addressZipCode + '\'' +
                ", enterpriseContact='" + enterpriseContact + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", allName='" + allName + '\'' +
                ", enterpriseNameEmployer='" + enterpriseNameEmployer + '\'' +
                ", creditCodeEmployer='" + creditCodeEmployer + '\'' +
                ", economicTypeCodeEmployer='" + economicTypeCodeEmployer + '\'' +
                ", industryCategoryCodeEmployer='" + industryCategoryCodeEmployer + '\'' +
                ", businessScaleCodeEmployer='" + businessScaleCodeEmployer + '\'' +
                ", addressCodeEmployer='" + addressCodeEmployer + '\'' +
                ", allNameEmployer='" + allNameEmployer + '\'' +
                ", tjh000='" + tjh000 + '\'' +
                ", workName='" + workName + '\'' +
                ", idCardTypeCode='" + idCardTypeCode + '\'' +
                ", idCard='" + idCard + '\'' +
                ", genderCode='" + genderCode + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", workerTelephone='" + workerTelephone + '\'' +
                ", jcType='" + jcType + '\'' +
                ", examTypeCode='" + examTypeCode + '\'' +
                ", examDate='" + examDate + '\'' +
                ", contactFactorCode='" + contactFactorCode + '\'' +
                ", contactFactorOther='" + contactFactorOther + '\'' +
                ", factorCode='" + factorCode + '\'' +
                ", factorOther='" + factorOther + '\'' +
                ", workTypeCode='" + workTypeCode + '\'' +
                ", otherWorkType='" + otherWorkType + '\'' +
                ", isReview='" + isReview + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", examConclusionList=" + examConclusionList +
                ", examItemResultList=" + examItemResultList +
                ", writePerson='" + writePerson + '\'' +
                ", writeUnit='" + writeUnit + '\'' +
                ", writePersonTelephone='" + writePersonTelephone + '\'' +
                ", writeDate='" + writeDate + '\'' +
                ", reportOrganCreditCode='" + reportOrganCreditCode + '\'' +
                ", reportPerson='" + reportPerson + '\'' +
                ", reportPersonTel='" + reportPersonTel + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", reportUnit='" + reportUnit + '\'' +
                ", remark='" + remark + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", auditInfo='" + auditInfo + '\'' +
                ", auditDate='" + auditDate + '\'' +
                ", auditorName='" + auditorName + '\'' +
                ", auditOrg='" + auditOrg + '\'' +
                '}';
    }
}
