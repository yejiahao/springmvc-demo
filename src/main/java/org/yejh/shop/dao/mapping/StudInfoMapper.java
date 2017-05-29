package org.yejh.shop.dao.mapping;

import org.yejh.shop.entity.StudInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/30.
 */
public interface StudInfoMapper {
    List<StudInfo> getStudInfo(StudInfo studInfo);

    Integer save(StudInfo studInfo);
}
