package org.yejh.shop.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yejh.shop.dao.UserInfoDao;
import org.yejh.shop.entity.UserInfo;
import org.yejh.shop.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    @Qualifier(value = "userInfoDao")
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getById(Integer id) {
        try {
            return userInfoDao.getById(id);
        } catch (Exception e) {
            LOG.error("getById: ", e);
            throw e;
        }
    }

    @Override
    public List<UserInfo> findAll(UserInfo userInfo) {
        try {
            int offset = 0;
            int length = 10;
            return userInfoDao.findAll(userInfo, offset, length);
        } catch (Exception e) {
            LOG.error("findAll: ", e);
            throw e;
        }
    }

    @Override
    public Integer save(UserInfo userInfo) {
        try {
            return userInfoDao.save(userInfo);
        } catch (Exception e) {
            LOG.error("save: ", e);
            throw e;
        }
    }

}
