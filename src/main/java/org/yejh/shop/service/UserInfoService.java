package org.yejh.shop.service;

import org.yejh.shop.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo getById(Integer id);

    List<UserInfo> findAll(UserInfo userInfo);

    Integer save(UserInfo userInfo);
}
