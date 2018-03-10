package org.yejh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yejh.shop.constant.Constants;
import org.yejh.shop.dao.LoginDao;
import org.yejh.shop.entity.User;
import org.yejh.shop.service.LoginService;
import org.yejh.shop.util.CommonUtil;
import org.yejh.shop.util.MD5Util;

import java.util.Map;

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
    public Map<String, Object> loginVerify(String account, String password) {
        Integer code = Constants.FAILURE_CODE;
        String message = Constants.USER_NOT_EXISTS;
        Object entity = null;
        try {
            User user = loginDao.getUserByAccountOrEmail(account);
            if (user != null) {
                password = MD5Util.encode(password);
                if (password.equals(user.getPassword())) {
                    code = Constants.SUCCESS_CODE;
                    message = Constants.USER_VERIFY_SUCCESS;
                    entity = user;
                } else {
                    message = Constants.PASS_ERROR;
                }
            }
        } catch (Exception e) {
            LOG.error("loginVerify: ", e);
            message = Constants.SERVER_INTERNAL_EXCEPTION;
        } finally {
            return CommonUtil.initResultMap(code, message, entity);
        }
    }

    @Override
    public Map<String, Object> updatePassword(String[] passwdArray, User user) {
        // passwdArray[]: [oldPasswd, newPasswd1, newPasswd2]
        Integer code = Constants.FAILURE_CODE;
        String message = "";
        try {
            if (passwdArray[1] == null || !passwdArray[1].equals(passwdArray[2])) {
                message = Constants.TWICE_NEW_PASSWD;
            } else if (passwdArray[1].equals(passwdArray[0])) {
                message = Constants.NOT_ALLOW_PREV_PASSWD;
            } else if (!MD5Util.encode(passwdArray[0]).equals(user.getPassword())) {
                message = Constants.PREV_PASSWD_ERROR;
            } else {
                Integer uId = user.getuId();
                String password = MD5Util.encode(passwdArray[1]);
                if (loginDao.updatePassword(new User(uId, password)) == 0) {
                    message = Constants.PASSWD_MODIFY_FAILURE;
                } else {
                    user.setPassword(password);
                    code = Constants.SUCCESS_CODE;
                    message = Constants.PASSWD_MODIFY_SUCCESS;
                }
            }
        } catch (Exception e) {
            LOG.error("updatePassword: ", e);
            message = Constants.SERVER_INTERNAL_EXCEPTION;
        } finally {
            return CommonUtil.initResultMap(code, message);
        }
    }
}
