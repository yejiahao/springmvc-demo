package org.yejh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yejh.shop.dao.mapping.CourseMapper;
import org.yejh.shop.service.CourseService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ye Jiahao
 * @create 2019-05-06
 * @since 4.0
 */
@Service
public class CourseServiceImpl implements CourseService {
    private static final Logger LOG = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    CourseMapper mapper;

    @Override
    public Map<String, Object> listCourse() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("total", mapper.countCourse());
            result.put("items", mapper.listCourse());
            return result;
        } catch (Exception e) {
            LOG.error("listCourse: {}", e.getMessage(), e);
            throw e;
        }
    }

}
