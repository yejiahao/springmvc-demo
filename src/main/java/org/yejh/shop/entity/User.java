package org.yejh.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/30.
 */
public class User implements Serializable {
    private String email;
    private String account;
    private String password;
    private String userName;
    private Integer gender;// 0 → female, 1 → male
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(String email, String account, String password, String userName, Integer gender, Date createTime, Date updateTime) {
        this.email = email;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
