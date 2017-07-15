package org.yejh.shop.dao;

import org.yejh.shop.entity.Location;
import org.yejh.shop.entity.StudInfo;

/**
 * Created by Administrator on 2017/5/30.
 */
public interface StudInfoDao extends GenericDao<StudInfo, Integer> {
    Location getStudInfoLocation(StudInfo studInfo);

    Integer updateLocation(Integer sId, Location location);
}
