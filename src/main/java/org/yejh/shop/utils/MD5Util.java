package org.yejh.shop.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Ye Jiahao on 2017/06/04.
 */
public class MD5Util {
    private MD5Util() {
        throw new AssertionError();
    }

    public static String encode(String inputStr) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(inputStr.getBytes());
        String outputStr = new BigInteger(1, md.digest()).toString(16);
        return outputStr;
    }
}
