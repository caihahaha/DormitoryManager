package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.entity.ClassInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import com.gdut.dormitory_system.service.ClassInfoService;
import com.gdut.dormitory_system.util.HostHolder;
import com.gdut.dormitory_system.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.controller
 * @ClassName: ClassInfoController
 * @Author: csb
 * Date: 2022/7/27 15:54
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Controller
public class ClassInfoController {

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping(value = "/findClassInfo",method = {RequestMethod.GET, RequestMethod.POST})
    public String getClassInfo( @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "code", required = false) String code,
                                 @RequestParam(value = "className", required = false) String className,
                                 @RequestParam(value = "counsellor", required = false) String counsellor, Model model) {
        PageInfo<ClassInfo> page = new PageInfo<>(pageNum, pageSize);
        page.setPath("/findClassInfo");
        model.addAttribute("page", classInfoService.findClassInfoPage(page, code, className, counsellor));
        model.addAttribute("code", code);
        model.addAttribute("className", className);
        model.addAttribute("counsellor", counsellor);
        return "class_list";
    }

    @PostMapping("/exportClassList")
    @ResponseBody
    public List<ClassInfo> exportClassList() {
        return classInfoService.findAllClassInfo();
    }

    @PostMapping("/addClassInfo")
    @ResponseBody
    public String addClassInfo(@RequestBody ClassInfo classInfo) {
        Admin admin = hostHolder.getAdmin();
        if (admin == null) {
            return JSONUtils.getJSONString(403, "请先登录！");
        }
        int row = classInfoService.addClassInfo(classInfo);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "添加成功");
        }
        return JSONUtils.getJSONString(0, "添加失败");
    }

    @PostMapping("/updateClassInfo")
    @ResponseBody
    public String updateClassInfo(@RequestBody ClassInfo classInfo) {
        Admin admin = hostHolder.getAdmin();
        if (admin == null) {
            return JSONUtils.getJSONString(403, "请先登录！");
        }
        int row = classInfoService.updateClassInfoById(classInfo);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "修改成功");
        }
        return JSONUtils.getJSONString(0, "修改失败");
    }

    @PostMapping("/deleteClassInfo/{id}")
    @ResponseBody
    public String deleteClassInfo(@PathVariable("id") Integer id) {
        Admin admin = hostHolder.getAdmin();
        if (admin == null) {
            return JSONUtils.getJSONString(403, "请先登录！");
        }
        int row = classInfoService.deleteClassInfoById(id);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "删除成功");
        }
        return JSONUtils.getJSONString(0, "删除失败");
    }

    @GetMapping("/findClassInfoById/{id}")
    public String findClassInfoById(@PathVariable Integer id, Model model) {
        ClassInfo classInfo = classInfoService.findClassInfoById(id);
        model.addAttribute("classInfo", classInfo);
        return "class_edit";
    }

    @RequestMapping(value = "/findClassStudent",method = {RequestMethod.GET, RequestMethod.POST})
    public String getClassStudent(Model model,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "classCode", required = false) String classCode,
                               @RequestParam(value = "className", required = false) String className) {
        PageInfo<Student> page = new PageInfo<>(pageNum, pageSize);
        page.setPath("/findClassStudent");
        page = classInfoService.findClassStudent(page, classCode, className);
        model.addAttribute("page", page);
        model.addAttribute("classCode", classCode);
        model.addAttribute("className", className);
        return "class_student_list";
    }
}
