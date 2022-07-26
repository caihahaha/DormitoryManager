package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.dao.StudentDao;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import com.gdut.dormitory_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

/**
 * @PackgeName: com.gdut.dormitory_system.service.impl
 * @ClassName: StudentServiceImpl
 * @Author: csb
 * Date: 2022/7/26 17:45
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public PageInfo<Student> findAllStudent(PageInfo<Student> page, QueryStudentVO queryStudentVO) {
        return studentDao.selectAllStudent(page, queryStudentVO);
    }
}
