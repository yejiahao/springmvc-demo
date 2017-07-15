package org.yejh.shop.dao.mapping;

import org.yejh.shop.entity.Location;
import org.yejh.shop.entity.StudInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/30.
 */
public interface StudInfoMapper {
    List<StudInfo> getStudInfo(Map<String, Object> dataMap);

    List<Location> getStudInfoLocation(Map<String, Object> dataMap);

    Integer save(StudInfo studInfo);

    Integer totalCounts(Map<String, Object> reqMap);

    Integer updateLocation(Map<String, Object> reqMap);
}
