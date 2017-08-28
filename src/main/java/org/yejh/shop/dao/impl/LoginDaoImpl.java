package org.yejh.shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.LoginDao;
import org.yejh.shop.dao.mapping.UserMapper;
import org.yejh.shop.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Autowired
    UserMapper mapper;

    @Override
    public User getUserByAccountOrEmail(String account) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account", account);
        User user = mapper.getUserByAccountOrEmail(paramMap);
        return user;
    }

    @Override
    public Integer updatePassword(User user) {
        return mapper.updatePassword(user);
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll(User user, int offset, int length) {
        return null;
    }

    @Override
    public Integer save(User entity) {
        return null;
    }

    @Override
    public Integer update(User entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Integer totalCounts(User user) {
        return null;
    }
}
