package com.gdut.dormitory_system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import com.gdut.dormitory_system.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @PackgeName: com.gdut.dormitory_system
 * @ClassName: StudentServiceTests
 * @Author: csb
 * Date: 2022/7/26 17:39
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@SpringBootTest
@ContextConfiguration(classes = DormitorySystemApplication.class)
public class StudentServiceTests {

    @Autowired
    StudentService studentService;

    @Test
    public void test1() {
        PageInfo<Student> page = new PageInfo<>(20,10);
//        QueryStudentVO queryStudentVO = QueryStudentVO.builder().name("张").build();
        System.out.println(studentService.findAllStudent(page, null).getRecords());
        System.out.println(page.getTotal());
    }
}
