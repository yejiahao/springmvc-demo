package org.yejh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yejh.shop.base.RespObj;
import org.yejh.shop.service.CourseService;
import org.yejh.shop.util.CommonUtil;

import java.util.Map;

/**
 * @author Ye Jiahao
 * @create 2019-05-05
 * @since 4.0
 */
@RestController
@RequestMapping(value = "/course")
public class CourseController extends BaseController {
    @Autowired
    CourseService service;

    @GetMapping(value = "/listCourseItem")
    public RespObj listCourseItem() {
        try {
            Map<String, Object> courses = service.listCourse();
            return CommonUtil.isOK(courses);
        } catch (Exception e) {
            return CommonUtil.failFast();
        }
    }

}
