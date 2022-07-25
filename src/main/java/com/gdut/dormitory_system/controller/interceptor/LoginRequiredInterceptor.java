package com.gdut.dormitory_system.controller.interceptor;

import com.gdut.dormitory_system.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zwj
 * @Date: 2022/7/26 0:33
 * @Description: 拦截请求，判断用户是否登录
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {
    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // hostHolder对象为空，表示未登录
        if (hostHolder.getAdmin() == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        return true;
    }
}
