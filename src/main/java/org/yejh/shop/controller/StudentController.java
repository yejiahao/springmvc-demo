package org.yejh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.yejh.shop.entity.Location;
import org.yejh.shop.entity.StudInfo;
import org.yejh.shop.service.StudInfoService;

import java.util.List;

@Controller
@RequestMapping(value = "/stud")
public class StudentController extends BaseController {
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
        if (totalPages < 1) {
            totalPages = 1;// avoid bootstrap-paginator.js throw "Page out of range"
        }
        LOG.info("totalCounts: {}, totalPages: {}", totalCounts, totalPages);


        Integer pageOffset = (page - 1) * pageLength;
        List<StudInfo> studentList = studInfoService.findAll(studInfo, pageOffset, pageLength);
        LOG.info("查询学生列表: {}", studentList);

        mv.addObject("currentPage", page);
        mv.addObject("totalPages", totalPages);
        mv.addObject("studentList", studentList);
        return mv;
    }

    @PostMapping(value = "/updateLocation")
    @ResponseBody
    public Boolean updateLocation(StudInfo studInfo, Location location) {
        Boolean isUpdate = Boolean.FALSE;
        try {
            Integer result = studInfoService.updateLocation(studInfo.getsId(), location);
            if (result > 0) {
                isUpdate = Boolean.TRUE;
            }
        } catch (Exception e) {
            LOG.error("updateLocation", e);
        } finally {
            return isUpdate;
        }
    }

    @GetMapping(value = "/getLocation")
    @ResponseBody
    public Object getLocation(StudInfo studInfo) {
        LOG.info("sId: {}", studInfo.getsId());
        Location location = studInfoService.getStudInfoLocation(studInfo);
        LOG.info("location: {}", location);
        return location;
    }

    @DeleteMapping(value = "/delStud")
    @ResponseBody
    public Boolean delStud(Integer sId) {
        LOG.info("sId: {}", sId);
        return studInfoService.delStud(sId);
    }
}
