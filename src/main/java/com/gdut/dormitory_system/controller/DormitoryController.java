package com.gdut.dormitory_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    /*
    分页带条件查询
     */
    @RequestMapping(value = "/findDormitory")
    public String findDormitory(@RequestParam(value = "adminName",required = false) String adminName,
                                @RequestParam(value = "code",required = false)String code,
                                @RequestParam(value = "dormitoryLocation",required = false)String dormitoryLocation,
                                @RequestParam(value = "pageNum",required = false ,defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model){
        PageInfo<DormitoryInfo> page = dormitoryService.findDormitory(adminName,code,dormitoryLocation,pageNum,pageSize);
        page.setPath("/findDormitory");
        model.addAttribute("page",page);
        return "dormitory_list";
    }

    /*
        根据宿舍主键(id)查询
     */
    @RequestMapping("/findDormitoryById")
    public String findDormitoryById(Integer id,Model model){
        DormitoryInfo dormitoryInfo = dormitoryService.findDormitoryById(id);
        model.addAttribute("d",dormitoryInfo);
        return "dormitory_edit";

    }





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

    /*
        修改宿舍
     */
    @RequestMapping(value = "/updateDormitory",method = RequestMethod.POST)
    public String updateDormitory(DormitoryInfo dormitoryInfo,HttpSession session){
        int res = dormitoryService.updateDormitory(dormitoryInfo);
        //如果想整弹窗，这里可以加判断
        return "redirect:/findDormitory";
    }

    /*
        导出excel
     */

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormitorylist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormitoryInfo> exportDormitory(){
        List<DormitoryInfo> dormitoryList = dormitoryService.findAll();
        return dormitoryList;
    }

}
