package org.yejh.shop.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public String login(@RequestParam String account, @RequestParam String password) {
		logger.info("account: {}\tpassword: {}", account, password);
		logger.info("进入登录页面");
		return "/loginSuccess";
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

}
