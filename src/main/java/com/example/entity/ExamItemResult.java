package com.example.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 检查项目信息
 *
 * @author dragon
 * @date 2021/6/22
 */
public class ExamItemResult implements Serializable {

    private static final long serialVersionUID = 792094511122349722L;

    /**
     * 体检号
     */
    private String tjh000;

    /**
     * 检查项目父级名称(检查指标名称一级节点名称)
     */
    @NotBlank(message = "检查项目父级名称不能为空")
    private String examItemPname;

    /**
     * 检查项目名称
     */
    @NotBlank(message = "检查项目名称不能为空")
    private String examItemName;

    /**
     * 检查项目代码
     */
    @NotBlank(message = "检查项目代码不能为空")
    private String examItemCode;

    /**
     * 检查结果类型代码
     * 01 数值型、02 字符型、03 枚举型
     */
    @NotBlank(message = "检查结果类型代码不能为空")
    private String examResultType;
    /**
     * 检查结果
     */
    @NotBlank(message = "检查结果不能为空")
    private String examResult;

    /**
     * 检查项目计量单位(只有检查结果为数字类型的需要填写，没有时可不填写-)
     */
    private String examItemUnitCode;
    /**
     * 参考值范围小值
     * <p>
     * 检查结果为数 字类型时必填
     */
    private String referenceRangeMin;

    /**
     * 参考值范围大值
     * <p>
     * 检查结果为数 字类型时必填
     */
    private String referenceRangeMax;

    /**
     * 是否异常(true/false)
     * <p>
     * 0 正常、1 异常、 3 未检查;当检 查项目是胸片 时，参见数据元 值域代码表:胸 片检查结果代 码表
     */
    @NotBlank(message = "是否异常不能为空")
    private String abnormal;

    public String getExamItemPname() {
        return examItemPname;
    }

    public void setExamItemPname(String examItemPname) {
        this.examItemPname = examItemPname;
    }

    public String getExamItemName() {
        return examItemName;
    }

    public void setExamItemName(String examItemName) {
        this.examItemName = examItemName;
    }

    public String getExamItemCode() {
        return examItemCode;
    }

    public void setExamItemCode(String examItemCode) {
        this.examItemCode = examItemCode;
    }

    public String getExamResultType() {
        return examResultType;
    }

    public void setExamResultType(String examResultType) {
        this.examResultType = examResultType;
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    public String getExamItemUnitCode() {
        return examItemUnitCode;
    }

    public void setExamItemUnitCode(String examItemUnitCode) {
        this.examItemUnitCode = examItemUnitCode;
    }

    public String getReferenceRangeMin() {
        return referenceRangeMin;
    }

    public void setReferenceRangeMin(String referenceRangeMin) {
        this.referenceRangeMin = referenceRangeMin;
    }

    public String getReferenceRangeMax() {
        return referenceRangeMax;
    }

    public void setReferenceRangeMax(String referenceRangeMax) {
        this.referenceRangeMax = referenceRangeMax;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public String getTjh000() {
        return tjh000;
    }

    public void setTjh000(String tjh000) {
        this.tjh000 = tjh000;
    }
}
