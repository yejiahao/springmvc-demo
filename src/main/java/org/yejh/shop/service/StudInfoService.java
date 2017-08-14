package org.yejh.shop.service;

import org.yejh.shop.entity.Location;
import org.yejh.shop.entity.StudInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface StudInfoService {
    StudInfo getById(Integer sid);

    Location getStudInfoLocation(StudInfo studInfo);

    List<StudInfo> findAll(StudInfo studInfo, int pageOffset, int pageLength);

    Integer save(StudInfo studInfo);

    Integer totalCounts(StudInfo studInfo);

    Integer updateLocation(Integer sId, Location location);

    boolean delStud(Integer sId);
}
