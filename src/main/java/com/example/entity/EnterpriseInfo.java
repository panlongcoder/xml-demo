package com.example.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用人单位信息
 *
 * @author dragon
 * @date 2021/6/22
 */
public class EnterpriseInfo implements Serializable {

    private static final long serialVersionUID = 7920217109451119722L;

    @NotNull(message = "团检id不能为空")
    private String id;

    @NotBlank(message = "用人单位名称不能为空")
    private String name;

    @NotBlank(message = "统一社会信用代码不能为空")
    private String creditCode;

    /**
     * 参见数据元值 域代码表:地区/机构代码表
     */
    @NotBlank(message = "所属地区代码不能为空")
    private String addressCode;

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
     * 是否为子公司，0 表示否，1 表示是
     */
    @NotNull(message = "是否为子公司不能为空")
    private Integer isSubsidiary;

    /**
     * 子公司二级代码(当为子公司需填写) (条件必填)
     */
    private String twoLevelCode;

    /**
     * 创建地区代码
     */
    @NotBlank(message = "创建地区代码不能为空")
    private String areaCode;

    @NotBlank(message = "创建机构代码不能为空")
    private String orgCode;

    @NotBlank(message = "填表单位名称不能为空")
    private String writeUnit;

    @NotBlank(message = "填表人姓名不能为空")
    private String writePerson;

    @NotBlank(message = "填表人联系电话不能为空")
    private String writePersonTel;

    /**
     * 日期格式 yyyyMMdd
     */
    @NotBlank(message = "填表日期不能为空")
    private String writeDate;

    @NotBlank(message = "报告单位名称不能为空")
    private String reportUnit;

    @NotBlank(message = "报告人姓名不能为空")
    private String reportPerson;

    @NotBlank(message = "报告人电话不能为空")
    private String reportPersonTel;

    /**
     * 日期格式 yyyyMMdd
     */
    @NotBlank(message = "报告日期不能为空")
    private String reportDate;

    /**
     * 用人单位所在区全名称
     */
    private String allName;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
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

    public Integer getIsSubsidiary() {
        return isSubsidiary;
    }

    public void setIsSubsidiary(Integer isSubsidiary) {
        this.isSubsidiary = isSubsidiary;
    }

    public String getTwoLevelCode() {
        return twoLevelCode;
    }

    public void setTwoLevelCode(String twoLevelCode) {
        this.twoLevelCode = twoLevelCode;
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

    public String getWriteUnit() {
        return writeUnit;
    }

    public void setWriteUnit(String writeUnit) {
        this.writeUnit = writeUnit;
    }

    public String getWritePerson() {
        return writePerson;
    }

    public void setWritePerson(String writePerson) {
        this.writePerson = writePerson;
    }

    public String getWritePersonTel() {
        return writePersonTel;
    }

    public void setWritePersonTel(String writePersonTel) {
        this.writePersonTel = writePersonTel;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
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

    public String getAllName() {
        return allName;
    }

    public void setAllName(String allName) {
        this.allName = allName;
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
