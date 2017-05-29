package org.yejh.shop.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/30.
 */
public class User implements Serializable {
    private String account;
    private String password;

    public User() {

    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
