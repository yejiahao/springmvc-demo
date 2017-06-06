package org.yejh.shop.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ye Jiahao on 2017/06/06.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    private static final String[] NO_INTERCEPT_PATH = new String[]{"/login/", "/css/", "/fonts/", "/image/", "/js/"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("---------------- LoginInterceptor preHandle -------------------");
        String requestURI = request.getRequestURI();
        LOG.info("RequestURI: {}", requestURI);

        Boolean isLoginPath = false;
        for (int i = 0, length = NO_INTERCEPT_PATH.length; i < length; i++) {
            if (requestURI.contains(NO_INTERCEPT_PATH[i])) {
                isLoginPath = true;
                break;
            }
        }

        Boolean hasLoginSession = request.getSession().getAttribute("loginUser") != null;
        if (!isLoginPath && !hasLoginSession) {
            LOG.error("您还未登录或登录已超时，请重新登录");
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
