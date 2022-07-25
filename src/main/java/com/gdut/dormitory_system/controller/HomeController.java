package com.gdut.dormitory_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/index")
    public String getHomePage() {
        return "/home_page";
    }
}
