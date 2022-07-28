package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.StudentGrade;
import com.gdut.dormitory_system.entity.vo.QueryStudentGradeVo;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;

import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/28 9:51
 * @Description:
 */
public interface StudentCleanService {

    PageInfo<StudentGrade> findPageInfo(QueryStudentGradeVo queryStudentGradeVo, PageInfo<StudentGrade> pageInfo);

    List<StudentGrade> getAll();

    int addStudentGrade(StudentGrade studentGrade);

    int deleteStudentGrade(Integer id);

    int updateStudentGrade(StudentGrade studentGrade);

    StudentGrade findStudentGradeById(Integer id);
}
