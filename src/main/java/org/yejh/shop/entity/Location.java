package org.yejh.shop.entity;

import java.io.Serializable;

/**
 * Created by Ye Jiahao on 2017/03/19.
 */
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    private String provincePostCode;
    private String provinceName;
    private String cityPostCode;
    private String cityName;
    private String areaPostCode;
    private String areaName;

    public Location() {
    }

    public Location(String provincePostCode, String provinceName, String cityPostCode, String cityName,
                    String areaPostCode, String areaName) {
        this.provincePostCode = provincePostCode;
        this.provinceName = provinceName;
        this.cityPostCode = cityPostCode;
        this.cityName = cityName;
        this.areaPostCode = areaPostCode;
        this.areaName = areaName;
    }

    public String getProvincePostCode() {
        return provincePostCode;
    }

    public void setProvincePostCode(String provincePostCode) {
        this.provincePostCode = provincePostCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityPostCode() {
        return cityPostCode;
    }

    public void setCityPostCode(String cityPostCode) {
        this.cityPostCode = cityPostCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaPostCode() {
        return areaPostCode;
    }

    public void setAreaPostCode(String areaPostCode) {
        this.areaPostCode = areaPostCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "LocationDto [provincePostCode=" + provincePostCode + ", provinceName=" + provinceName
                + ", cityPostCode=" + cityPostCode + ", cityName=" + cityName + ", areaPostCode=" + areaPostCode
                + ", areaName=" + areaName + "]";
    }

}
