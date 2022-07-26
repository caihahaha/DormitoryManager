package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.dao.StudentDao;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import com.gdut.dormitory_system.service.DormitoryService;
import com.gdut.dormitory_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;

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

    @Autowired
    private DormitoryService dormitoryService;

    @Override
    public PageInfo<Student> findAllStudent(PageInfo<Student> page, QueryStudentVO queryStudentVO) {
        return studentDao.selectAllStudent(page, queryStudentVO);
    }

    @Override
    public int addStudent(Student student) {
        List<DormitoryInfo> dormitoryInfo = dormitoryService.findOneByCode(student.getDormitoryCode());
        if (dormitoryInfo.size() == 0) {
            return -2;
        }
        student.setDormitoryId(dormitoryInfo.get(0).getId());
        return studentDao.insert(student);
    }

    @Override
    public int updateStudentById(Student student) {
        List<DormitoryInfo> dormitoryInfo = dormitoryService.findOneByCode(student.getDormitoryCode());
        if (dormitoryInfo.size() == 0) {
            return -2;
        }
        student.setDormitoryId(dormitoryInfo.get(0).getId());
        return studentDao.updateById(student);
    }

    @Override
    public int deleteStudentById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public PageInfo<Student> findAllStudentForClass(PageInfo<Student> page, String classCode, String className) {
        return studentDao.selectAllStudentForClass(page, classCode, className);
    }
}
