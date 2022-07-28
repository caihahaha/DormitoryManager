package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.StudentGrade;
import com.gdut.dormitory_system.entity.Visitor;
import com.gdut.dormitory_system.entity.vo.QueryStudentGradeVo;
import com.gdut.dormitory_system.entity.vo.QueryVisitorVO;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;
import com.gdut.dormitory_system.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/28 9:50
 * @Description:
 */
@Controller
public class StudentCleanController {

    @Autowired
    private StudentCleanService studentCleanService;

    @RequestMapping("/findStudentClean")
    public String findStudentClean(QueryStudentGradeVo queryStudentGradeVo,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   Model model) {

        PageInfo<StudentGrade> page = new PageInfo<>(pageIndex, pageSize);
        page.setPath(("/findStudentClean"));
        if (queryStudentGradeVo == null) {
            queryStudentGradeVo = new QueryStudentGradeVo();
        }
        page = studentCleanService.findPageInfo(queryStudentGradeVo, page);
        model.addAttribute("page", page);
        // model.addAttribute("admin", hostHolder.getAdmin());
        for (StudentGrade vo : page.getRecords()) {
            System.out.println(vo.getName());
        }

        return "studentclean_list";
    }

    @PostMapping("/exportStudentCleanList")
    @ResponseBody
    public List<StudentGrade> exportStudentClean(){
        // List<StudentGrade> studentGradeList = studentCleanService.findPageInfo(null, new PageInfo<>(1,100)).getRecords();

        List<StudentGrade> studentGradeList = studentCleanService.getAll();
        return studentGradeList;
    }

    @PostMapping("/addStudentClean")
    @ResponseBody
    public String addDormClean(@RequestBody StudentGrade studentGrade) {
        int res = studentCleanService.addStudentGrade(studentGrade);
        return "studentclean_list";
    }

    @RequestMapping( "/deleteStudentClean")
    @ResponseBody
    public String deleteDormClean(Integer id) {
        int res = studentCleanService.deleteStudentGrade(id);
        return "studentclean_list";
    }

    @RequestMapping( "/updateStudentClean")
    public String updateDormClean(StudentGrade studentGrade) {
        int res = studentCleanService.updateStudentGrade(studentGrade);
        return "redirect:/findStudentClean";
    }

    @RequestMapping( "/findStudentCleanById")
    public String findDormCleanById(Integer id, HttpSession session) {

        StudentGrade stu = studentCleanService.findStudentGradeById(id);
        session.setAttribute("stu",stu);
        return "studentclean_edit";
    }
}
