package com.example.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author dragon
 * @date 2021/6/22
 */
public class WorkInfo implements Serializable {

    private static final long serialVersionUID = 7119209451119722L;

    /**
     * 姓名
     */
    @NotBlank(message = "劳动者姓名不能为空")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
