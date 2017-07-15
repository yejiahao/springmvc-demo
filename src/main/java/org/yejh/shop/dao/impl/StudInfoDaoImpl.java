package org.yejh.shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.StudInfoDao;
import org.yejh.shop.dao.mapping.StudInfoMapper;
import org.yejh.shop.entity.Location;
import org.yejh.shop.entity.StudInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/30.
 */
@Repository("studInfoDao")
public class StudInfoDaoImpl implements StudInfoDao {
    @Autowired
    private StudInfoMapper mapper;

    @Override
    public StudInfo getById(Integer id) {
        StudInfo studInfo = new StudInfo();
        studInfo.setsId(id);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("studInfo", studInfo);
        studInfo = mapper.getStudInfo(paramMap).get(0);
        return studInfo;
    }

    @Override
    public Location getStudInfoLocation(StudInfo studInfo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("studInfo", studInfo);
        Location location = mapper.getStudInfoLocation(paramMap).get(0);
        if (location == null) {
            location = new Location();
        }
        return location;
    }

    @Override
    public List<StudInfo> findAll(StudInfo studInfo, int offset, int length) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("studInfo", studInfo);
        paramMap.put("offset", offset);
        paramMap.put("length", length);
        List<StudInfo> studInfoList = mapper.getStudInfo(paramMap);
        return studInfoList;
    }

    @Override
    public Integer save(StudInfo studInfo) {
        Integer result = mapper.save(studInfo);
        return result;
    }

    @Override
    public Integer update(StudInfo entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Integer totalCounts(StudInfo studInfo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("studInfo", studInfo);
        return mapper.totalCounts(paramMap);
    }

    @Override
    public Integer updateLocation(Integer sId, Location location) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sId", sId);
        paramMap.put("location", location);
        return mapper.updateLocation(paramMap);
    }
}
