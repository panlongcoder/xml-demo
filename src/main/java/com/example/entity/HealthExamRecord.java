package com.example.entity;

import javax.validation.constraints.NotBlank;
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

    /**
     * 职业健康档案id(不能重复)
     */
    private String id;


    /**
     * 用人单位信息
     */
    private EnterpriseInfo enterpriseInfo;

    /**
     * 用工单位信息
     */
    private EnterpriseInfoEmployer enterpriseInfoEmployer;

    /**
     * 劳动者信息
     */
    private WorkInfo workInfo;


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
     * 填表人名称
     */
    @NotBlank(message = "填表人名称不能为空")
    private String writePerson;

    /**
     * 填表人电话
     */
    @NotBlank(message = "填表人电话不能为空")
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
     * 备注
     */
    private String remark;
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
     * 开始接害日期 yyyyMMdd
     * 检查类型是岗前 时非必填
     */
    private String harmStartDate;
    /**
     * 实际接害工龄 年
     */
    @NotBlank(message = "实际接害工龄(年)不能为空")
    private String harmAgeYear;
    /**
     * 实际接害工龄 月
     */
    @NotBlank(message = "实际接害工龄(月)不能为空")
    private String harmAgeMonth;
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
     * 报告单位名称
     */
    @NotBlank(message = "报告单位名称不能为空")
    private String reportUnit;
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
     * 劳动者联系电话
     */
    @NotBlank(message = "劳动者联系电话不能为空")
    private String workerTelephone;
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
     * 体检结论集合
     */
    private List<ExamConclusion> examConclusionList;


    /**
     * 检查项目信息集合
     */
    private List<ExamItemResult> examItemResultList;

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

    public EnterpriseInfo getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }

    public WorkInfo getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(WorkInfo workInfo) {
        this.workInfo = workInfo;
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

    public String getWritePerson() {
        return writePerson;
    }

    public void setWritePerson(String writePerson) {
        this.writePerson = writePerson;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getHarmStartDate() {
        return harmStartDate;
    }

    public void setHarmStartDate(String harmStartDate) {
        this.harmStartDate = harmStartDate;
    }

    public String getHarmAgeYear() {
        return harmAgeYear;
    }

    public void setHarmAgeYear(String harmAgeYear) {
        this.harmAgeYear = harmAgeYear;
    }

    public String getHarmAgeMonth() {
        return harmAgeMonth;
    }

    public void setHarmAgeMonth(String harmAgeMonth) {
        this.harmAgeMonth = harmAgeMonth;
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

    public String getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit;
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

    public String getWorkerTelephone() {
        return workerTelephone;
    }

    public void setWorkerTelephone(String workerTelephone) {
        this.workerTelephone = workerTelephone;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJcType() {
        return jcType;
    }

    public void setJcType(String jcType) {
        this.jcType = jcType;
    }

    public EnterpriseInfoEmployer getEnterpriseInfoEmployer() {
        return enterpriseInfoEmployer;
    }

    public void setEnterpriseInfoEmployer(EnterpriseInfoEmployer enterpriseInfoEmployer) {
        this.enterpriseInfoEmployer = enterpriseInfoEmployer;
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
}
