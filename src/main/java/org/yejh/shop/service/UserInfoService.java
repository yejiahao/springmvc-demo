package org.yejh.shop.service;

import java.util.List;

import org.yejh.shop.entity.UserInfo;

public interface UserInfoService {
	UserInfo getById(Integer id);

	List<UserInfo> findAll(UserInfo userInfo);

	Integer save(UserInfo userInfo);
}
