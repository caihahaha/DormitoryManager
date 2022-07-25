package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    public String getLogin() {
        return "/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Admin admin = adminService.findAdminByUsernameAndPwd(username, password);
        if (admin != null) {
            return "redirect:/index";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "/login";
    }
}
