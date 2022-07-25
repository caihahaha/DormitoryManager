package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PackgeName: com.gdut.dormitory_system.controller
 * @ClassName: HomeController
 * @Author: csb
 * Date: 2022/7/25 17:51
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Controller
public class HomeController {

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private AdminService adminService;

    @GetMapping("/index")
    public String getHomePage(Model model) {
        model.addAttribute("user", adminService.findAdminById(hostHolder.getAdmin().getId()));
        return "/home_page";
    }
}
