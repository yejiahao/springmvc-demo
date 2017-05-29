package org.yejh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yejh.shop.dao.StudInfoDao;
import org.yejh.shop.entity.StudInfo;
import org.yejh.shop.service.StudInfoService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service("studInfoService")
public class StudInfoServiceImpl implements StudInfoService {
    private static final Logger logger = LoggerFactory.getLogger(StudInfoServiceImpl.class);

    @Autowired
    @Qualifier(value = "studInfoDao")
    private StudInfoDao studInfoDao;

    @Override
    public StudInfo getById(Integer sid) {
        try {
            return studInfoDao.getById(sid);
        } catch (Exception e) {
            logger.error("getById: ", e);
            return null;
        }

    }

    @Override
    public List<StudInfo> findAll() {
        try {
            return studInfoDao.findAll();
        } catch (Exception e) {
            logger.error("findAll: ", e);
            return null;
        }
    }

    @Override
    public Integer save(StudInfo studInfo) {
        try {
            return studInfoDao.save(studInfo);
        } catch (Exception e) {
            logger.error("save: ", e);
            return null;
        }
    }
}
