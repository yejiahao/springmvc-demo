package org.yejh.shop.service;

import org.yejh.shop.entity.User;

import java.util.Map;

public interface RegisterService {
    Map<String, Object> register(User registerUser);
}
