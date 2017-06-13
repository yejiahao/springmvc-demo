package org.yejh.shop.service;

import org.yejh.shop.entity.StudInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface StudInfoService {
    StudInfo getById(Integer sid);

    List<StudInfo> findAll(StudInfo studInfo, int pageOffset, int pageLength);

    Integer save(StudInfo studInfo);

    Integer totalCounts(StudInfo studInfo);
}
