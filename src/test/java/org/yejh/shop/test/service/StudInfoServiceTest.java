package org.yejh.shop.test.service;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yejh.shop.entity.StudInfo;
import org.yejh.shop.service.StudInfoService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", "classpath*:/mybatis/*.xml" })
public class StudInfoServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(StudInfoServiceTest.class);

    @Autowired
    @Qualifier(value = "studInfoService")
    private StudInfoService studInfoService;

    @Before
    public void beforeTest() {
        logger.info("Before StudInfoServiceTest ----------");
    }

    @After
    public void afterTest() {
        logger.info("After StudInfoServiceTest ----------");
    }

    @Test
    public void testGetById() {
        Integer sId = 1;
        StudInfo student = studInfoService.getById(sId);
        logger.info(JSON.toJSONStringWithDateFormat(student, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void testFindAll() {
        List<StudInfo> studentList = studInfoService.findAll();
        for (int i = 0; i < studentList.size(); i++) {
            logger.info(JSON.toJSONStringWithDateFormat(studentList.get(i), "yyyy-MM-dd HH:mm:ss"));
        }
    }

    @Test
    public void testSave() {
        StudInfo student = new StudInfo("Java", 8080, new Date());
        Integer count = studInfoService.save(student);
        logger.info("count= {}", count);
    }
}