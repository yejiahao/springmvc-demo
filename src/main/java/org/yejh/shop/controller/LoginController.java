package org.yejh.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yejh.shop.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    public ModelAndView login(String account, String password, HttpSession session) {
        ModelAndView mv = new ModelAndView("/main");
        if (session.getAttribute("loginUser") != null) {
            logger.info("{} have been logined", session.getAttribute("loginUser"));
        } else {
            logger.info("account: {}\tpassword: {}", account, password);
            if ("yejiahao".equals(account) && "123".equals(password)) {
                User user = new User(account, password);
                session.setAttribute("loginUser", user);
            } else {
                logger.info("login: account or password error");
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

        logger.info("parent: {}", parent);
        logger.info("child: {}", child);

        File newFile = new File(parent, child);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            logger.error("uploadFile transferTo: ", e);
        }

        model.addAttribute("filePath", request.getContextPath() + "/upload/" + child);
        logger.info("uploading file...");
        return "/uploadSuccess";
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public ModelAndView logout(HttpSession session) {
        logger.info("session: {}", session);
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login.jsp");
        return mv;
    }

}
