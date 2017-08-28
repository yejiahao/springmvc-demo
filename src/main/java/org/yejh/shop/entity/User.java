package org.yejh.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/30.
 */
public class User implements Serializable {
    private Integer uId;
    private String email;
    private String account;
    private String password;
    private String userName;
    private Integer gender;// 0 → female, 1 → male
    private Integer role;// 1 → user, 2 → admin
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(Integer uId, String password) {
        this.uId = uId;
        this.password = password;
    }

    public User(String email, String account, String password, String userName, Integer gender, Integer role, Date createTime, Date updateTime) {
        this.email = email;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
                "uId=" + uId +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", role=" + role +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
