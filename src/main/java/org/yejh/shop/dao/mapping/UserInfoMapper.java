package org.yejh.shop.dao.mapping;

import java.util.List;

import org.yejh.shop.entity.UserInfo;

public interface UserInfoMapper {
    List<UserInfo> getUserInfo(UserInfo userInfo);

    Integer save(UserInfo userInfo);
}
