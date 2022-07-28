package com.gdut.dormitory_system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;

/**
 * @PackgeName: com.gdut.dormitory_system.service
 * @ClassName: StudentService
 * @Author: csb
 * Date: 2022/7/26 17:44
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public interface StudentService {

    PageInfo<Student> findAllStudent(PageInfo<Student> page, QueryStudentVO queryStudentVO);

    int addStudent(Student student);

    int updateStudentById(Student student);

    int deleteStudentById(Integer id);

    Student findStudentById(Integer id);
}
