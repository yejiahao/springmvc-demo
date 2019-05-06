package org.yejh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.yejh.shop.base.RespObj;
import org.yejh.shop.dao.RegisterDao;
import org.yejh.shop.entity.User;
import org.yejh.shop.service.RegisterService;
import org.yejh.shop.util.CommonUtil;
import org.yejh.shop.util.MD5Util;

import java.util.Date;
import java.util.Objects;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    private static final Logger LOG = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    @Qualifier("registerDao")
    private RegisterDao registerDao;

    @Override
    public RespObj register(User registerUser) {
        Integer code = RespObj.FAILURE_CODE;
        String message = "";
        try {
            StringBuffer info = new StringBuffer();
            registerValidate(registerUser, info);
            if (info.length() != 0) {
                code = RespObj.USER_VALIDATE_ERROR_CODE;
                message = info.toString();
            } else {
                String emailAccount = registerUser.getEmailAccount();
                String emailDomain = registerUser.getEmailDomain();
                if (!StringUtils.isEmpty(emailAccount) || !StringUtils.isEmpty(emailDomain)) {
                    registerUser.setEmail(String.format("%s@%s", emailAccount, emailDomain));
                }
                registerUser.setPassword(MD5Util.encode(registerUser.getPassword()));
                Date now = new Date();
                registerUser.setCreateTime(now);
                registerUser.setUpdateTime(now);
                Integer result = registerDao.save(registerUser);
                LOG.debug("register success: {}", registerUser);
                code = RespObj.SUCCESS_CODE;
                message = RespObj.USER_REGISTER_SUCCESS;
            }
        } catch (Exception e) {
            LOG.error("register: " + e.getMessage(), e);
            message = RespObj.SERVER_INTERNAL_EXCEPTION;
        } finally {
            return CommonUtil.initResp(code, message);
        }
    }

    private void registerValidate(User registerUser, StringBuffer info) {
        if (StringUtils.isEmpty(registerUser.getAccount())) {
            info.append(RespObj.USER_ACCOUNT_NOT_EMPTY + "\n");
        }
        if (StringUtils.isEmpty(registerUser.getUserName())) {
            info.append(RespObj.USER_NAME_NOT_EMPTY + "\n");
        }
        if (!Objects.equals(registerUser.getPassword(), registerUser.getPasswdConfirm())) {
            info.append(RespObj.TWICE_NEW_PASSWD + "\n");
        }
    }
}
