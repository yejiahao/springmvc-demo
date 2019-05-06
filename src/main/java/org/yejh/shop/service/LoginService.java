package org.yejh.shop.service;

import org.yejh.shop.base.RespObj;
import org.yejh.shop.entity.User;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
public interface LoginService {
    RespObj loginVerify(String account, String password);

    RespObj updatePassword(String[] passwdArray, User user);
}
