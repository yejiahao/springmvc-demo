package org.yejh.shop.service;

import org.yejh.shop.entity.StudInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface StudInfoService {
    StudInfo getById(Integer sid);

    List<StudInfo> findAll();

    Integer save(StudInfo studInfo);
}
