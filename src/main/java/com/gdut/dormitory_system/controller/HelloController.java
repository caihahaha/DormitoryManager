package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
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
