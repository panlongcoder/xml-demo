package com.example.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 体检结论信息
 *
 * @author dragon
 * @date 2021/6/22
 */
public class ExamConclusion implements Serializable {

    private static final long serialVersionUID = 79209451119722L;

    /**
     * 团检号
     */
    private String tjh000;

    /**
     * 职业病危害因素代码
     */
    @NotBlank(message = "职业病危害因素代码不能为空")
    private String itamCode;

    /**
     * 危害因素名称
     */
    @NotBlank(message = "危害因素名称不能为空")
    private String itamName;

    /**
     * 体检结论代码
     *
     * 参见数据元值域代码表:体检结论代码表
     */
    @NotBlank(message = "体检结论代码不能为空")
    private String examConclusionCode;

    /**
     * 疑似职业病代码
     *
     * 当体检结论是疑似职业病时，该项必填参见数据元值域代码表:职业病种类代码表
     */
    private String yszybCode;

    /**
     * 职业禁忌证名称
     *
     * 当体检结论是职业禁忌症时，该项必填
     */
    private String zyjjzName;

    /**
     * 其他疾病或异常描述(当体检结论是其他疾病或异常时，需填写该字段)
     *
     *
     */
    private String qtjbName;

    /**
     * 开始接害日期
     */
    private String harmStartDate;

    /**
     * 实际接害工龄- 年
     */
    private String harmAgeYear;

    /**
     * 实际接害工龄- 月
     */
    private String harmAgeMonth;

    public String getItamCode() {
        return itamCode;
    }

    public void setItamCode(String itamCode) {
        this.itamCode = itamCode;
    }

    public String getItamName() {
        return itamName;
    }

    public void setItamName(String itamName) {
        this.itamName = itamName;
    }

    public String getExamConclusionCode() {
        return examConclusionCode;
    }

    public void setExamConclusionCode(String examConclusionCode) {
        this.examConclusionCode = examConclusionCode;
    }

    public String getYszybCode() {
        return yszybCode;
    }

    public void setYszybCode(String yszybCode) {
        this.yszybCode = yszybCode;
    }

    public String getZyjjzName() {
        return zyjjzName;
    }

    public void setZyjjzName(String zyjjzName) {
        this.zyjjzName = zyjjzName;
    }

    public String getQtjbName() {
        return qtjbName;
    }

    public void setQtjbName(String qtjbName) {
        this.qtjbName = qtjbName;
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

    public String getTjh000() {
        return tjh000;
    }

    public void setTjh000(String tjh000) {
        this.tjh000 = tjh000;
    }
}
