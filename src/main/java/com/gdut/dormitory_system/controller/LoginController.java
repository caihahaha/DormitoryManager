package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.HostHolder;
import com.gdut.dormitory_system.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @PackgeName: com.gdut.dormitory_system.controller
 * @ClassName: LoginController
 * @Author: csb
 * Date: 2022/7/24 17:06
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HostHolder hostHolder;

    @Value("${dormitory-system.ticket-expired-seconds}")
    private Integer expiredSeconds;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @GetMapping("/login")
    public String getLogin() {
        return "/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletResponse resp) {
        Map<String, String> map = adminService.login(username, password, expiredSeconds);
        if (map.get("ticket") != null) {
            Cookie cookie = new Cookie("ticket", map.get("ticket"));
            cookie.setPath(contextPath);
            cookie.setMaxAge(expiredSeconds);
            resp.addCookie(cookie);
            return "redirect:/index";
        }
        model.addAttribute("msg", map.get("msg"));
        return "/login";
    }

    @RequestMapping("/loginOut")
    public String loginOut(@CookieValue("ticket") String ticket) {
         adminService.loginOut(ticket);
         hostHolder.clear();
         return "redirect:/login";
    }
}
