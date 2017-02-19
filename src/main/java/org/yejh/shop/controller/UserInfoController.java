package org.yejh.shop.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yejh.shop.entity.UserInfo;
import org.yejh.shop.service.UserInfoService;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/user")
public class UserInfoController {
	private static final Logger logger = Logger.getLogger(UserInfoController.class);

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
		logger.info("查看单个用户userId： " + userId);
		UserInfo userInfo = userInfoService.getById(userId);
		modelMap.addAttribute("userInfo", userInfo);
		modelMap.addAttribute("now", new Date());
		return "/user/showInfo";
	}

	@RequestMapping(value = "/showInfos")
	public @ResponseBody List<UserInfo> showUserInfos() {
		List<UserInfo> userInfoList = userInfoService.findAll();
		logger.info("查看全部用户: " + userInfoList);
		return userInfoList;
	}

	@RequestMapping("/showInfosInGrid")
	public String showInfosInGrid(HttpServletRequest request, ModelMap modelMap) {
		logger.info("全部用户信息放入表格");
		String[] unameList = request.getParameterValues("unameList");
		String[] unumberList = request.getParameterValues("unumberList");
		String[] uRegisterTimeList = request.getParameterValues("uRegisterTimeList");
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		String jsonStr = null;
		for (int i = 0; i < unameList.length; i++) {
			String uname;
			Integer unumber;
			Date uRegisterTime;
			try {
				uname = unameList[i];
				unumber = Integer.parseInt(unumberList[i]);
				uRegisterTime = new SimpleDateFormat("yyyy-MM-dd").parse(uRegisterTimeList[i]);
				userInfoList.add(new UserInfo(uname, unumber, uRegisterTime));
				jsonStr = JSON.toJSONString(userInfoList);

			} catch (Exception e) {
				logger.error("showInfosInGrid： ", e);
			}
		}
		modelMap.addAttribute("userList", jsonStr);
		return "/gridPanel/simpleGrid";
	}
}
