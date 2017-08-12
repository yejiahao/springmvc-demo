package org.yejh.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class StudInfo implements Serializable {
    private Integer sId;
    private String sName;
    private Integer sNumber;
    private Date sRegisterTime;
    private Date sRegisterTimeBegin;
    private Date sRegisterTimeEnd;

    private Integer age;
    private Integer gender;// 0 → female, 1 → male
    private Integer grade;// 1 → freshman, 2 → sophomoreer, 3 → junior, 4 → senior
    private String professional;

    public StudInfo() {
    }

    public StudInfo(String sName, Integer sNumber, Date sRegisterTime, Integer age, Integer gender, Integer grade, String professional) {
        this.sName = sName;
        this.sNumber = sNumber;
        this.sRegisterTime = sRegisterTime;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.professional = professional;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsNumber() {
        return sNumber;
    }

    public void setsNumber(Integer sNumber) {
        this.sNumber = sNumber;
    }

    public Date getsRegisterTime() {
        return sRegisterTime;
    }

    public void setsRegisterTime(Date sRegisterTime) {
        this.sRegisterTime = sRegisterTime;
    }

    public Date getsRegisterTimeBegin() {
        return sRegisterTimeBegin;
    }

    public void setsRegisterTimeBegin(Date sRegisterTimeBegin) {
        this.sRegisterTimeBegin = sRegisterTimeBegin;
    }

    public Date getsRegisterTimeEnd() {
        return sRegisterTimeEnd;
    }

    public void setsRegisterTimeEnd(Date sRegisterTimeEnd) {
        this.sRegisterTimeEnd = sRegisterTimeEnd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "StudInfo{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sNumber=" + sNumber +
                ", sRegisterTime=" + sRegisterTime +
                ", sRegisterTimeBegin=" + sRegisterTimeBegin +
                ", sRegisterTimeEnd=" + sRegisterTimeEnd +
                ", age=" + age +
                ", gender=" + gender +
                ", grade=" + grade +
                ", professional='" + professional + '\'' +
                '}';
    }
}
