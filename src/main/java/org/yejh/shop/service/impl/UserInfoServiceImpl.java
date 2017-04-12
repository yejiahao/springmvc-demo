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
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Autowired
	@Qualifier(value = "userInfoDao")
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo getById(Integer id) {
		try {
			UserInfo userInfo = userInfoDao.getById(id);
			return userInfo;
		} catch (Exception e) {
			logger.error("getById: ", e);
			return null;
		}
	}

	@Override
	public List<UserInfo> findAll() {
		try {
			List<UserInfo> userInfoList = userInfoDao.findAll();
			return userInfoList;
		} catch (Exception e) {
			logger.error("findAll: ", e);
			return null;
		}
	}

	@Override
	public Integer save(UserInfo userInfo) {
		try {
			Integer affectedCount = userInfoDao.save(userInfo);
			return affectedCount;
		} catch (Exception e) {
			logger.error("save: ", e);
			return null;
		}
	}

}
