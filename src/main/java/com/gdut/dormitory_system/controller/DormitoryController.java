package com.gdut.dormitory_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    /*
    分页带条件查询
     */
    @RequestMapping("/findDormitory")
    public String findDormitory(String adminName, Integer id, String dormitoryLocation,
                                Integer pageIndex, Integer pageSize,Model model){
        IPage<DormitoryInfo> page = dormitoryService.findDormitory(adminName,id,dormitoryLocation,pageIndex,pageSize);
        model.addAttribute("di",page);
        return "dormitory_list";
    }

    /*
        根据宿舍编号（code）查询
     */



    /*
        添加宿舍
     */
    @RequestMapping("/addDormitory")
    @ResponseBody
    public String addDormitory(@RequestBody DormitoryInfo dormitoryInfo){
        int i = dormitoryService.addDormitory(dormitoryInfo);
        return "dormitory_list";
    }


    /*
        删除宿舍
     */

    @RequestMapping("/deleteDormitory")
    @ResponseBody
    public String deleteDormitory( Integer dormitoryId){
        int d = dormitoryService.deleteById(dormitoryId);
        return "dormitory_list";
    }


}
