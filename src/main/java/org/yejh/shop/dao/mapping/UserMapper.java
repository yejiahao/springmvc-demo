package org.yejh.shop.dao.mapping;

import org.yejh.shop.entity.User;

import java.util.Map;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
public interface UserMapper {
    User getUserByAccountOrEmail(Map<String, Object> paramMap);

    Integer updatePassword(User user);
}
