package org.yejh.shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yejh.shop.entity.UserInfo;
import org.yejh.shop.service.UserInfoService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserInfoController extends BaseController {
    private static final Logger LOG = Logger.getLogger(UserInfoController.class);

    @Autowired
    @Qualifier(value = "userInfoService")
    private UserInfoService userInfoService;

    @RequestMapping(value = "/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
        LOG.info("查看单个用户userId： " + userId);
        UserInfo userInfo = userInfoService.getById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        modelMap.addAttribute("now", new Date());
        return "/user/showInfo";
    }

    @RequestMapping(value = "/showInfos")
    public ModelAndView showUserInfos(UserInfo userInfo) {
        List<UserInfo> userInfoList = userInfoService.findAll(userInfo);
        LOG.info("查看全部用户: " + userInfoList);
        ModelAndView mv = new ModelAndView();
        mv.addObject(userInfoList);
        mv.setViewName("/student/studentlist");
        return mv;
    }
}
