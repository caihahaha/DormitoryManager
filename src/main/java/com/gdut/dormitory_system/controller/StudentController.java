package com.gdut.dormitory_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.entity.ClassInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import com.gdut.dormitory_system.service.ClassInfoService;
import com.gdut.dormitory_system.service.DormitoryService;
import com.gdut.dormitory_system.service.StudentService;
import com.gdut.dormitory_system.util.HostHolder;
import com.gdut.dormitory_system.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackgeName: com.gdut.dormitory_system.controller
 * @ClassName: StudentController
 * @Author: csb
 * Date: 2022/7/26 12:08
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Controller
public class StudentController {

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassInfoService classInfoService;

    @Autowired
    private DormitoryService dormitoryService;

    @RequestMapping(value = "/findStudent",method = {RequestMethod.GET, RequestMethod.POST})
    public String getStudentPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 QueryStudentVO queryStudentVO,
                                 Model model) {
        PageInfo<Student> page = new PageInfo<>(pageNum, pageSize);
        page.setPath("/findStudent");
        if (queryStudentVO == null) {
            queryStudentVO = new QueryStudentVO();
        }
        model.addAttribute("page", studentService.findAllStudent(page, queryStudentVO));
        model.addAttribute("queryStudentVO", queryStudentVO);

        List<ClassInfo> classInfoList = classInfoService.findAllClassInfo();
        model.addAttribute("classList", classInfoList);

        return "student_list";
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public String addStudent(@RequestBody Student student) {
        int row = studentService.addStudent(student);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "添加成功");
        }
        if (row == -2) {
            return JSONUtils.getJSONString(0, "查无该编号的宿舍，请重新确认");
        }
        return JSONUtils.getJSONString(0, "添加失败");
    }

    @PostMapping("/updateStudent")
    @ResponseBody
    public String updateStudent(@RequestBody Student student) {
        int row = studentService.updateStudentById(student);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "修改成功");
        }
        if (row == -2) {
            return JSONUtils.getJSONString(0, "查无该编号的宿舍，请重新确认");
        }
        return JSONUtils.getJSONString(0, "修改失败");
    }

    @PostMapping("/deleteStudent/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable("id") Integer id) {
        int row = studentService.deleteStudentById(id);
        if (row > 0) {
            return JSONUtils.getJSONString(1, "删除成功");
        }
        return JSONUtils.getJSONString(0, "删除失败");
    }

    @RequestMapping(value = "/findStudentById/{id}",method = {RequestMethod.GET, RequestMethod.POST})
    public String findStudentById(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.findStudentById(id);
        student.setDormitoryCode(dormitoryService.findDormitoryById(student.getDormitoryId()).getCode());
        model.addAttribute("student", student);

        List<ClassInfo> classInfoList = classInfoService.findAllClassInfo();
        model.addAttribute("classList", classInfoList);

        return "student_edit";
    }
}
