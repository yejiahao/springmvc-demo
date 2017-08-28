package org.yejh.shop.service;

import org.yejh.shop.entity.User;

import java.util.Map;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
public interface LoginService {
    Map<String, Object> loginVerify(String account, String password);

    Map<String, Object> updatePassword(String[] passwdArray, User user);
}
