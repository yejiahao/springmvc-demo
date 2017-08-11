package org.yejh.shop.utils;

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
        byte[] digest = md.digest();
        final String HEX = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(digest.length * 2);
        for (byte b : digest) {
            sb.append(HEX.charAt((b >> 4) & 0x0f));
            sb.append(HEX.charAt(b & 0x0f));
        }
        return sb.toString();
    }
}
