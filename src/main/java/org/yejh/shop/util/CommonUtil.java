package org.yejh.shop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yejh.shop.base.RespObj;

/**
 * Created by Ye Jiahao on 2017/8/23.
 */
public class CommonUtil {
    private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

    private CommonUtil() {
        throw new AssertionError();
    }

    public static RespObj isOK(Object data) {
        return initResp(RespObj.SUCCESS_CODE, RespObj.IS_OK, data);
    }

    public static RespObj failFast() {
        return initResp(RespObj.FAILURE_CODE, RespObj.IS_ERROR, null);
    }

    public static RespObj initResp(Integer code, String message) {
        return initResp(code, message, null);
    }

    public static RespObj initResp(Integer code, String message, Object data) {
        RespObj resp = new RespObj(code, message, data);
        LOG.info("respObj: {}", resp);
        return resp;
    }
}
