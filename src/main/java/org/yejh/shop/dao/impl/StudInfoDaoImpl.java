package org.yejh.shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yejh.shop.dao.StudInfoDao;
import org.yejh.shop.dao.mapping.StudInfoMapper;
import org.yejh.shop.entity.StudInfo;

import java.util.List;

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
        studInfo = mapper.getStudInfo(studInfo).get(0);
        return studInfo;
    }

    @Override
    public List<StudInfo> findAll() {
        List<StudInfo> studInfoList = mapper.getStudInfo(null);
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
}
