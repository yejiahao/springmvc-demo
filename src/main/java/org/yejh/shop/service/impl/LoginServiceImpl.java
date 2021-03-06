package org.yejh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yejh.shop.base.RespObj;
import org.yejh.shop.dao.LoginDao;
import org.yejh.shop.entity.User;
import org.yejh.shop.service.LoginService;
import org.yejh.shop.util.CommonUtil;
import org.yejh.shop.util.MD5Util;

import java.util.Objects;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    @Qualifier("loginDao")
    private LoginDao loginDao;

    @Override
    public RespObj loginVerify(String account, String password) {
        Integer code = RespObj.FAILURE_CODE;
        String message = RespObj.USER_NOT_EXISTS;
        Object data = null;
        try {
            User user = loginDao.getUserByAccountOrEmail(account);
            if (user != null) {
                password = MD5Util.encode(password);
                if (password.equals(user.getPassword())) {
                    code = RespObj.SUCCESS_CODE;
                    message = RespObj.USER_VERIFY_SUCCESS;
                    data = user;
                } else {
                    message = RespObj.PASS_ERROR;
                }
            }
        } catch (Exception e) {
            LOG.error("loginVerify: ", e);
            message = RespObj.SERVER_INTERNAL_EXCEPTION;
        } finally {
            return CommonUtil.initResp(code, message, data);
        }
    }

    @Override
    public RespObj updatePassword(String[] passwdArray, User user) {
        // passwdArray[]: [oldPasswd, newPasswd1, newPasswd2]
        Integer code = RespObj.FAILURE_CODE;
        String message = "";
        try {
            if (!Objects.equals(passwdArray[1], passwdArray[2])) {
                message = RespObj.TWICE_NEW_PASSWD;
            } else if (Objects.equals(passwdArray[1], passwdArray[0])) {
                message = RespObj.NOT_ALLOW_PREV_PASSWD;
            } else if (!Objects.equals(MD5Util.encode(passwdArray[0]), user.getPassword())) {
                message = RespObj.PREV_PASSWD_ERROR;
            } else {
                Integer uId = user.getuId();
                String password = MD5Util.encode(passwdArray[1]);
                if (loginDao.updatePassword(new User(uId, password)) == 0) {
                    message = RespObj.PASSWD_MODIFY_FAILURE;
                } else {
                    code = RespObj.SUCCESS_CODE;
                    message = RespObj.PASSWD_MODIFY_SUCCESS;
                }
            }
        } catch (Exception e) {
            LOG.error("updatePassword: " + e.getMessage(), e);
            message = RespObj.SERVER_INTERNAL_EXCEPTION;
        } finally {
            return CommonUtil.initResp(code, message);
        }
    }
}
