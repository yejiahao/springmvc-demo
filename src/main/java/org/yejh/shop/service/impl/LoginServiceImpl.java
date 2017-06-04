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
import org.yejh.shop.utils.MD5Util;

import java.util.HashMap;
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

        Map<String, Object> resultMap = new HashMap<String, Object>() {
            {
                put("code", Constants.FAILURE_CODE);
                put("message", Constants.USER_NOT_EXISTS);
            }
        };
        try {
            User user = loginDao.getUserByAccountOrEamil(account);
            if (user != null) {
                password = MD5Util.encode(password);
                if (password.equals(user.getPassword())) {
                    resultMap.put("code", Constants.SUCCESS_CODE);
                    resultMap.put("message", Constants.USER_VERIFY_SUCCESS);
                    resultMap.put("user", user);
                } else {
                    resultMap.put("message", Constants.PASS_ERROR);
                }
            }
        } catch (Exception e) {
            LOG.error("loginVerify: ", e);
            resultMap.put("message", Constants.SERVER_INTERNAL_EXCEPTION);
        } finally {
            LOG.info("resultMap: {}", resultMap);
            return resultMap;
        }
    }
}
