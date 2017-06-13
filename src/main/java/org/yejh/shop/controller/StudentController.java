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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/stud")
public class StudentController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    @Qualifier(value = "studInfoService")
    private StudInfoService studInfoService;

    @RequestMapping(value = "/showStudInfos", method = {RequestMethod.GET})
    public ModelAndView showStudInfos(StudInfo studInfo, Integer page) {
        LOG.info("studInfo: {}, page: {}", studInfo, page);
        ModelAndView mv = new ModelAndView();
        String viewName = "/student/studentlisttable";

        // first-in
        if (page == null) {
            page = 1;
            viewName = "/student/studentlist";
        }

        Integer totalCounts = studInfoService.totalCounts(studInfo);
        Integer totalPages = totalCounts % pageLength == 0 ? totalCounts / pageLength : totalCounts / pageLength + 1;
        LOG.info("totalCounts: {}, totalPages: {}", totalCounts, totalPages);


        Integer pageOffset = (page - 1) * pageLength;
        List<StudInfo> studentList = studInfoService.findAll(studInfo, pageOffset, pageLength);
        LOG.info("查询学生列表: {}", studentList);

        mv.addObject("currentPage", page);
        mv.addObject("totalPages", totalPages);
        mv.addObject("studentList", studentList);
        mv.setViewName(viewName);
        return mv;
    }
}
