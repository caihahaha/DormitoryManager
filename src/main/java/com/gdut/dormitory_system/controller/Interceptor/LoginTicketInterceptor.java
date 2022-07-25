package com.gdut.dormitory_system.controller.Interceptor;

import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.entity.LoginTicket;
import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.CookieUtil;
import com.gdut.dormitory_system.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @PackgeName: com.gdut.dormitory_system.controller.Interceptor
 * @ClassName: LoginTicketInterceptor
 * @Author: csb
 * Date: 2022/7/25 23:47
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Component
public class LoginTicketInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ticket = CookieUtil.getValue(request, "ticket");
        if (ticket != null) {
            LoginTicket loginTicket = adminService.findAdminByTicket(ticket);
            if (loginTicket != null && loginTicket.getStatus() == 1 && loginTicket.getExpired().after(new Date())) {
                Admin admin = adminService.findAdminById(loginTicket.getAdminId());
                hostHolder.setAdmin(admin);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Admin admin = hostHolder.getAdmin();
        if (admin != null && modelAndView != null) {
            modelAndView.addObject("loginUser", admin);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
