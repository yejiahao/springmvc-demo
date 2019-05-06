package org.yejh.shop.service;

import org.yejh.shop.base.RespObj;
import org.yejh.shop.entity.User;

public interface RegisterService {
    RespObj register(User registerUser);
}
