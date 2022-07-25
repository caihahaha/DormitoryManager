package com.gdut.dormitory_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zwj
 * @Date: 2022/7/23 11:15
 * @Description:
 */
//@Controller
public class HelloController {

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }


}
