package org.yejh.shop.servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Ye Jiahao on 2017/08/27.
 */
public class MySessionListener implements HttpSessionListener {
    private static long count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
    }

    public static long getCount() {
        return count;
    }
}
