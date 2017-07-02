package org.yejh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yejh.shop.dao.StudInfoDao;
import org.yejh.shop.entity.Location;
import org.yejh.shop.entity.StudInfo;
import org.yejh.shop.service.StudInfoService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service("studInfoService")
public class StudInfoServiceImpl implements StudInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(StudInfoServiceImpl.class);

    @Autowired
    @Qualifier(value = "studInfoDao")
    private StudInfoDao studInfoDao;

    @Override
    public StudInfo getById(Integer sid) {
        try {
            return studInfoDao.getById(sid);
        } catch (Exception e) {
            LOG.error("getById: ", e);
            throw e;
        }
    }

    @Override
    public List<StudInfo> findAll(StudInfo studInfo, int pageOffset, int pageLength) {
        try {
            return studInfoDao.findAll(studInfo, pageOffset, pageLength);
        } catch (Exception e) {
            LOG.error("findAll: ", e);
            throw e;
        }
    }

    @Override
    public Integer save(StudInfo studInfo) {
        try {
            return studInfoDao.save(studInfo);
        } catch (Exception e) {
            LOG.error("save: ", e);
            throw e;
        }
    }

    @Override
    public Integer totalCounts(StudInfo studInfo) {
        try {
            return studInfoDao.totalCounts(studInfo);
        } catch (Exception e) {
            LOG.error("totalCount: ", e);
            throw e;
        }
    }

    @Override
    public Integer updateLocation(Integer sId, Location location) {
        try {
            return studInfoDao.updateLocation(sId, location);
        } catch (Exception e) {
            LOG.error("updateLocation: ", e);
            throw e;
        }
    }
}
