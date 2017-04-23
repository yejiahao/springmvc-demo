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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yejh.shop.entity.UserInfo;
import org.yejh.shop.service.UserInfoService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", "classpath*:/mybatis/*.xml" })
public class UserInfoServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

	@Autowired
	@Qualifier(value = "userInfoService")
	private UserInfoService userInfoService;

	@Before
	public void beforeTest() {
		logger.info("Before test ----------");
	}

	@After
	public void afterTest() {
		logger.info("After test ----------");
	}

	@Test
	public void testGetById() {
		Integer id = 1;
		UserInfo userInfo = userInfoService.getById(id);
		logger.info(JSON.toJSONStringWithDateFormat(userInfo, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testFindAll() {
		List<UserInfo> userInfoList = userInfoService.findAll();
		for (int i = 0; i < userInfoList.size(); i++) {
			logger.info(JSON.toJSONStringWithDateFormat(userInfoList.get(i), "yyyy-MM-dd HH:mm:ss"));
		}
	}

	@Test
	public void testSave() {
		UserInfo userInfo = new UserInfo("Java开发工程师", 200, new Date());
		Integer count = userInfoService.save(userInfo);
		logger.info("count= {}", count);
	}
}
