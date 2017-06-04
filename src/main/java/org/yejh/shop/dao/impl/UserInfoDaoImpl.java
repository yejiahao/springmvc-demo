package org.yejh.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.UserInfoDao;
import org.yejh.shop.dao.mapping.UserInfoMapper;
import org.yejh.shop.entity.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public UserInfo getById(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userInfo", userInfo);
        userInfo = mapper.getUserInfo(paramMap).get(0);
        return userInfo;
    }

    @Override
    public List<UserInfo> findAll(int offset, int length) {
        Map<String, Object> paramMap = new HashMap<>();
        List<UserInfo> userInfoList = mapper.getUserInfo(paramMap);
        return userInfoList;
    }

    @Override
    public Integer save(UserInfo userInfo) {
        Integer result = mapper.save(userInfo);
        return result;
    }

    @Override
    public Integer update(UserInfo entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Integer totalCounts() {
        return null;
    }
}
