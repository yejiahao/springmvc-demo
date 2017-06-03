package org.yejh.shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.StudInfoDao;
import org.yejh.shop.dao.mapping.StudInfoMapper;
import org.yejh.shop.entity.StudInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/30.
 */
@Repository(value = "studInfoDao")
public class StudInfoDaoImpl implements StudInfoDao {
    @Autowired
    private StudInfoMapper mapper;

    @Override
    public StudInfo getById(Integer id) {
        StudInfo studInfo = new StudInfo();
        studInfo.setsId(id);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("studInfo", studInfo);
        studInfo = mapper.getStudInfo(dataMap).get(0);
        return studInfo;
    }

    @Override
    public List<StudInfo> findAll(int offset, int length) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("offset", offset);
        dataMap.put("length", length);
        List<StudInfo> studInfoList = mapper.getStudInfo(dataMap);
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
    public Integer totalCounts() {
        return mapper.totalCounts();
    }
}
