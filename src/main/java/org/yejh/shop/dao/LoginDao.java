package org.yejh.shop.dao;

import org.yejh.shop.entity.User;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
public interface LoginDao extends GenericDao<User, Integer> {
    User getUserByAccountOrEmail(String account);

    Integer updatePassword(User user);
}
