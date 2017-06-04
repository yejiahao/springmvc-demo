package org.yejh.shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.constant.Constants;
import org.yejh.shop.dao.LoginDao;
import org.yejh.shop.dao.mapping.UserMapper;
import org.yejh.shop.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Autowired
    UserMapper mapper;

    @Override
    public User getUserByAccountOrEamil(String account) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account", account);
        User user = mapper.getUserByAccountOrEamil(paramMap);
        return user;
    }
}
