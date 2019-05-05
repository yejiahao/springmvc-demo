package org.yejh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yejh.shop.constant.Constants;
import org.yejh.shop.entity.User;
import org.yejh.shop.service.LoginService;
import org.yejh.shop.service.RegisterService;
import org.yejh.shop.servlet.MySessionListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @Autowired
    @Qualifier("registerService")
    private RegisterService registerService;

    @PostMapping(value = "/login")
    public ModelAndView login(String account, String password, HttpSession session) {
        ModelAndView mv = new ModelAndView("/main");
        if (session.getAttribute("loginUser") != null) {
            if (account != null) {
                session.setAttribute("now", new Date());
            }
            LOG.info("{} have been logged in", session.getAttribute("loginUser"));
        } else {
            LOG.info("account: {}", account);
            Map<String, Object> resultMap = loginService.loginVerify(account, password);
            int code = Integer.parseInt(String.valueOf(resultMap.get("code")));
            if (code == Constants.SUCCESS_CODE) {
                User user = (User) resultMap.get("entity");
                session.setAttribute("loginUser", user);
                session.setAttribute("now", new Date());
            } else {
                String errorMessage = String.valueOf(resultMap.get("message"));
                session.setAttribute("errorMessage", errorMessage);
                mv.setViewName("redirect:/login.jsp");
            }
        }
        return mv;
    }

    @GetMapping(value = "/getOnlineCount")
    @ResponseBody
    public long getOnlineCount() {
        return MySessionListener.getCount();
    }

    @GetMapping(value = "/accountSetting")
    public String accountSetting() {
        return "/login/accountsetting";
    }

    @PutMapping(value = "/updatePassword")
    @ResponseBody
    public Object updatePassword(@RequestBody String[] passwdArray, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        Map<String, Object> resultMap = loginService.updatePassword(passwdArray, user);
        return resultMap;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public Object register(User registerUser) {
        Map<String, Object> resultMap = registerService.register(registerUser);
        return resultMap;
    }

    @RequestMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, Model model) {
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
        return "/uploadsuccess";
    }

    @GetMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
        Object user = session.getAttribute("loginUser");
        if (user instanceof User) {
            LOG.info("user logout: {}", ((User) user).getAccount());
        }
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login.jsp");
        return mv;
    }
}
