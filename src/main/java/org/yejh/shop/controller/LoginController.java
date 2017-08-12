package org.yejh.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yejh.shop.constant.Constants;
import org.yejh.shop.entity.User;
import org.yejh.shop.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    private static final DateFormat DT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public ModelAndView login(String account, String password, HttpSession session) {
        ModelAndView mv = new ModelAndView("/main");
        if (session.getAttribute("loginUser") != null) {
            if (account != null) {
                session.setAttribute("now", DT.format(new Date()));
            }
            LOG.info("{} have been logged in", session.getAttribute("loginUser"));
        } else {
            LOG.info("account: {}\tpassword: {}", account, password);
            Map<String, Object> resultMap = loginService.loginVerify(account, password);
            int code = Integer.parseInt(String.valueOf(resultMap.get("code")));
            if (code == Constants.SUCCESS_CODE) {
                User user = (User) resultMap.get("user");
                session.setAttribute("loginUser", user);
                session.setAttribute("now", DT.format(new Date()));
            } else {
                String errorMessage = String.valueOf(resultMap.get("message"));
                session.setAttribute("errorMessage", errorMessage);
                mv.setViewName("redirect:/login.jsp");
            }
        }
        return mv;
    }

    @RequestMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file,
                             HttpServletRequest request, Model model) {
        String parent = request.getSession().getServletContext().getRealPath("upload");
        String child = file.getOriginalFilename();

        LOG.info("parent: {}", parent);
        LOG.info("child: {}", child);

        File newFile = new File(parent, child);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            LOG.error("uploadFile transferTo: ", e);
        }

        model.addAttribute("filePath", request.getContextPath() + "/upload/" + child);
        LOG.info("uploading file...");
        return "/uploadSuccess";
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public ModelAndView logout(HttpSession session) {
        LOG.info("session: {}", session);
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login.jsp");
        return mv;
    }

}
