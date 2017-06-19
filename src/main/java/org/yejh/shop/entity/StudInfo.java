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

    public StudInfo() {
    }

    public StudInfo(String sName, Integer sNumber, Date sRegisterTime) {
        this.sName = sName;
        this.sNumber = sNumber;
        this.sRegisterTime = sRegisterTime;
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

    @Override
    public String toString() {
        return "StudInfo{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sNumber=" + sNumber +
                ", sRegisterTime=" + sRegisterTime +
                ", sRegisterTimeBegin=" + sRegisterTimeBegin +
                ", sRegisterTimeEnd=" + sRegisterTimeEnd +
                '}';
    }
}
