package org.yejh.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yejh.shop.entity.StudInfo;
import org.yejh.shop.service.StudInfoService;

import java.util.List;

@Controller
@RequestMapping(value = "/stud")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    @Qualifier(value = "studInfoService")
    private StudInfoService studInfoService;

    @RequestMapping(value = "/showStudInfos", method = {RequestMethod.GET})
    public ModelAndView showStudInfos() {
        List<StudInfo> studentList = studInfoService.findAll();
        logger.info("查看全部学生: " + studentList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("studentList", studentList);
        mv.setViewName("/student/studentlist");
        return mv;
    }
}
