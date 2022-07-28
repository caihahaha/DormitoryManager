package com.gdut.dormitory_system.controller;


import com.gdut.dormitory_system.entity.DormitoryGrade;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.DormitoryGradeService;
import com.gdut.dormitory_system.service.DormitoryService;
import com.gdut.dormitory_system.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.controller
 * @ClassName: DormitoryGradeController
 * @Author: csb
 * Date: 2022/7/28 18:22
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Controller
public class DormitoryGradeController {

    @Autowired
    private DormitoryGradeService dormitoryGradeService;

    @Autowired
    private DormitoryService dormitoryService;


    @RequestMapping(value = "/findDormitoryGrade",method = {RequestMethod.GET, RequestMethod.POST})
    public String getDormitoryGradePage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "code", required = false) String code,
                               @RequestParam(value = "location", required = false) String location, Model model) {
        PageInfo<DormitoryGrade> page = new PageInfo<>(pageNum, pageSize);
        page.setPath("/findDormitoryGrade");
        model.addAttribute("page", dormitoryGradeService.findDormitoryGradePage(page, code, location));
        model.addAttribute("code", code);
        model.addAttribute("location", location);

        List<DormitoryInfo> dormitoryInfoList = dormitoryService.findAll();
        model.addAttribute("dormitoryInfoList", dormitoryInfoList);

        return "dormclean_list";
    }

    @PostMapping("/addDormitoryGrade")
    @ResponseBody
    public String addDormitoryGrade(@RequestBody DormitoryGrade dormitoryGrade) {
        int row = dormitoryGradeService.addDormitoryGrade(dormitoryGrade);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "添加成功");
        }
        return JSONUtils.getJSONString(0, "添加失败");
    }

    @PostMapping("/updateDormitoryGrade")
    @ResponseBody
    public String updateDormitoryGrade(@RequestBody DormitoryGrade dormitoryGrade) {
        int row = dormitoryGradeService.updateDormitoryGrade(dormitoryGrade);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "修改成功");
        }
        return JSONUtils.getJSONString(0, "修改失败");
    }

    @PostMapping("/deleteDormitoryGrade/{id}")
    @ResponseBody
    public String deleteDormitoryGrade(@PathVariable("id") Integer id) {
        int row = dormitoryGradeService.deleteDormitoryGradeById(id);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "删除成功");
        }
        return JSONUtils.getJSONString(0, "删除失败");
    }

    @GetMapping("/findDormitoryGradeById/{id}")
    public String findDormitoryGradeById(@PathVariable Integer id, Model model) {
        DormitoryGrade dormitoryGrade = dormitoryGradeService.findDormitoryGradeById(id);
        model.addAttribute("dormitoryGrade", dormitoryGrade);

        List<DormitoryInfo> dormitoryInfoList = dormitoryService.findAll();
        model.addAttribute("dormitoryInfoList", dormitoryInfoList);

        return "dormclean_edit";
    }
}
