package org.yejh.shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.RegisterDao;
import org.yejh.shop.dao.mapping.UserMapper;
import org.yejh.shop.entity.User;

import java.util.List;

@Repository("registerDao")
public class RegisterDaoImpl implements RegisterDao {
    @Autowired
    UserMapper mapper;

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
        return mapper.registerUser(entity);
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
