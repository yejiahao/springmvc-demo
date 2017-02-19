package org.yejh.shop.test.service;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yejh.shop.entity.UserInfo;
import org.yejh.shop.service.UserInfoService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class UserInfoServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

	@Autowired
	private UserInfoService userInfoService;

	@Before
	public void beforeTest() {
		logger.info("before test----------");
	}

	@After
	public void afterTest() {
		logger.info("after test----------");
	}

	@Test
	public void testGetById() {
		Integer id = 1;
		UserInfo userInfo = userInfoService.getById(id);
		logger.info(JSON.toJSONStringWithDateFormat(userInfo, "yyyy-MM-dd"));
	}

	@Test
	public void testFindAll() {
		List<UserInfo> userInfoList = userInfoService.findAll();
		for (int i = 0; i < userInfoList.size(); i++) {
			logger.info(JSON.toJSONStringWithDateFormat(userInfoList.get(i), "yyyy-MM-dd"));
		}
	}

	@Test
	public void testSave() {
		UserInfo userInfo = new UserInfo("郭梦凡", 100, new Date());
		Integer count = userInfoService.save(userInfo);
		logger.info("count= {}", count);
	}
}
