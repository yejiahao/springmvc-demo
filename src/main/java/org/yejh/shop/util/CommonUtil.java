package org.yejh.shop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ye Jiahao on 2017/8/23.
 */
public class CommonUtil {
    private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

    private CommonUtil() {
        throw new AssertionError();
    }

    public static Map<String, Object> initResultMap(Integer code, String message) {
        return initResultMap(code, message, null);
    }

    public static Map<String, Object> initResultMap(Integer code, String message, Object entity) {
        Map<String, Object> resultMap = new HashMap<String, Object>() {
            {
                put("code", code);
                put("message", message);
                put("entity", entity);
            }
        };
        LOG.info("resultMap: {}", resultMap);
        return resultMap;
    }
}
