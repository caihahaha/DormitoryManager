package com.gdut.dormitory_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.DormitoryRepair;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DormRepairController {

    @Autowired
    private DormRepairService dormRepairService;
    /*
        带条件的分页查询
     */
    @RequestMapping("/findDormRepair")
    public String findDormRepair(@RequestParam(value = "dormitoryId",required = false) Integer dormitoryId,
                                 @RequestParam(value = "studentId",required = false)Integer studentId,
                                 @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "3") Integer pageSize,
                                 Model model){
        PageInfo<DormitoryRepair> page = dormRepairService.findDormRepair(dormitoryId,studentId,pageNum,pageSize);
        page.setPath("/findDormRepair");
        model.addAttribute("page",page);
        return "dormrepair_list";
    }

    /*
        根据id查询信息
     */
    @RequestMapping("/findDormRepairById")
    public String findDormRepairById(Integer id,Model model){
        DormitoryRepair dormitoryRepair = dormRepairService.findOneById(id);
        model.addAttribute("dr",dormitoryRepair);
        return "dormrepair_edit";
    }

    /*
        添加宿舍维修信息
     */
    @RequestMapping("/addDormRepair")
    @ResponseBody
    public String addDormRepair(@RequestBody DormitoryRepair dormitoryRepair){
        int res = dormRepairService.addDormRepair(dormitoryRepair);
        return "dormrepair_list";
    }

    /*
        删除宿舍维修信息
     */
    @RequestMapping("/deleteDormRepair")
    public String deleteDormRepair(Integer id){
        int res = dormRepairService.deleteDormRepair(id);
        return "redirect:/findDormRepair";
    }

    /*
        修改宿舍维修信息
     */
    @RequestMapping("/updateDormRepair")
    public String updateDormRepair(DormitoryRepair dormitoryRepair){
        int res = dormRepairService.updateDormRepair(dormitoryRepair);
        return "redirect:/findDormRepair";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormrepairlist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormitoryRepair> exportDormrepair(){
        List<DormitoryRepair> dormRepairList = dormRepairService.getAll();
        return dormRepairList;
    }
}
