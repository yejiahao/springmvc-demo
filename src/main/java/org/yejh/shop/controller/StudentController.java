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
public class StudentController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    @Qualifier(value = "studInfoService")
    private StudInfoService studInfoService;

    @RequestMapping(value = "/showStudInfos", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showStudInfos(StudInfo studInfo, Integer page) {
        ModelAndView mv = new ModelAndView("/student/studentlisttable");

        // first-in
        if (page == null) {
            mv.setViewName("/student/studentlist");
            return mv;
        }

        LOG.info("studInfo: {}, page: {}", studInfo, page);

        Integer totalCounts = studInfoService.totalCounts(studInfo);
        Integer totalPages = totalCounts % pageLength == 0 ? totalCounts / pageLength : totalCounts / pageLength + 1;
        LOG.info("totalCounts: {}, totalPages: {}", totalCounts, totalPages);


        Integer pageOffset = (page - 1) * pageLength;
        List<StudInfo> studentList = studInfoService.findAll(studInfo, pageOffset, pageLength);
        LOG.info("查询学生列表: {}", studentList);

        mv.addObject("currentPage", page);
        mv.addObject("totalPages", totalPages);
        mv.addObject("studentList", studentList);
        return mv;
    }
}
