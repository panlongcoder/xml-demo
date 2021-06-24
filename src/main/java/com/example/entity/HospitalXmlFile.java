package com.example.entity;

/**
 * 职业病上报xml附件表
 *
 * @author dragon
 * @date 2021/6/24
 */
public class HospitalXmlFile {

    /**
     * xml附件类别 0:用人单位信息 1:职业健康档案
     */
    private Integer type;

    /**
     * 医院编码 引用PT_HOSPXX.YBH00
     */
    private String hospitalCode;

    /**
     * xml内容
     */
    private String content;

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 创建时间
     */
    private String createTime;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
