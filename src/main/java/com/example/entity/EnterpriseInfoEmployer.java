package com.example.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用工单位信息
 *
 * @author dragon
 * @date 2021/6/23
 */
public class EnterpriseInfoEmployer implements Serializable {

    private static final long serialVersionUID = 7920217109451119722L;

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


}
