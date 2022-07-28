package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Visitor;
import com.gdut.dormitory_system.entity.vo.QueryVisitorVO;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;
import com.gdut.dormitory_system.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String findStudetnClean(StudentCleanVo studentCleanVo,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   Model model) {

        PageInfo<StudentCleanVo> page = new PageInfo<>(pageIndex, pageSize);
        page.setPath(("/findStudentClean"));
        if (studentCleanVo == null) {
            studentCleanVo = new StudentCleanVo();
        }
        page = studentCleanService.findPageInfo(studentCleanVo, page);
        model.addAttribute("page", page);
        // model.addAttribute("admin", hostHolder.getAdmin());
        for (StudentCleanVo vo : page.getRecords()) {
            System.out.println(vo.getName());
        }

        return "visitor_list";
    }
}
