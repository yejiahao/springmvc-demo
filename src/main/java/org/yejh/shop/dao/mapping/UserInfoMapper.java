package org.yejh.shop.dao.mapping;

import java.util.List;
import java.util.Map;

import org.yejh.shop.entity.UserInfo;

public interface UserInfoMapper {
    List<UserInfo> getUserInfo(Map<String, Object> dataMap);

    Integer save(UserInfo userInfo);
}
