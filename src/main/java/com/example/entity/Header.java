package com.example.entity;


import com.example.enums.OperateType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 头部信息
 *
 * @author dragon
 * @date 2021/6/22
 */
public class Header implements Serializable {

    private static final long serialVersionUID = 7920945121211119722L;

    /**
     * 文档id(机构编码-业务类别代码-当前时间(yyyyMMddHHmmssSSS)-5位随机码)
     */
    @NotBlank(message = "文档标识ID不能为空")
    private String documentId;

    /**
     * 操作类型(Add Update Delete)
     */
    @NotNull(message = "操作类型不能为空")
    private OperateType operateType;

    /**
     * 业务活动标识 默认就是 NEWOMAR
     */
    @NotBlank(message = "业务活动标识不能为空")
    private String businessActivityIdentification = "NEWOMAR";

    /**
     * 上报地区代码
     */
    @NotBlank(message = "上报地区代码不能为空")
    private String reportZoneCode;

    /**
     * 上报机构代码
     */
    @NotBlank(message = "上报机构代码不能为空")
    private String reportOrgCode;

    /**
     * 上报机构授权码
     */
    @NotBlank(message = "上报机构授权码不能为空")
    private String license;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public OperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(OperateType operateType) {
        this.operateType = operateType;
    }

    public String getBusinessActivityIdentification() {
        return businessActivityIdentification;
    }

    public void setBusinessActivityIdentification(String businessActivityIdentification) {
        this.businessActivityIdentification = businessActivityIdentification;
    }

    public String getReportZoneCode() {
        return reportZoneCode;
    }

    public void setReportZoneCode(String reportZoneCode) {
        this.reportZoneCode = reportZoneCode;
    }

    public String getReportOrgCode() {
        return reportOrgCode;
    }

    public void setReportOrgCode(String reportOrgCode) {
        this.reportOrgCode = reportOrgCode;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Header(String documentId, OperateType operateType, String businessActivityIdentification, String reportZoneCode, String reportOrgCode, String license) {
        this.documentId = documentId;
        this.operateType = operateType;
        this.businessActivityIdentification = businessActivityIdentification;
        this.reportZoneCode = reportZoneCode;
        this.reportOrgCode = reportOrgCode;
        this.license = license;
    }

    public Header() {
    }
}
