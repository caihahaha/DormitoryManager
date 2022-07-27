package com.gdut.dormitory_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import com.gdut.dormitory_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private StudentService studentService;

    @RequestMapping(value = "/findStudent",method = {RequestMethod.GET, RequestMethod.POST})
    public String getStudentPage(Model model,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 @RequestBody(required = false) QueryStudentVO queryStudentVO) {
        PageInfo<Student> page = new PageInfo<>(pageNum, pageSize);
        page.setPath("/findStudent");
        if (queryStudentVO == null) {
            queryStudentVO = new QueryStudentVO();
        }
        model.addAttribute("page", studentService.findAllStudent(page, queryStudentVO));
        return "student_list";
    }
}
