package org.yejh.shop.dao;

import org.yejh.shop.entity.User;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
public interface LoginDao {
    User getUserByAccountOrEamil(String account);
}
