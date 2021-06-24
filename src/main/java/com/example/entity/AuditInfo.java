package com.example.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 审核信息
 *
 * @author dragon
 * @date 2021/6/22
 */
public class AuditInfo implements Serializable {

    private static final long serialVersionUID = 79202109451119722L;

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
