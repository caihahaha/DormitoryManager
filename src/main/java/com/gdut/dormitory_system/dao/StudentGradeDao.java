package com.gdut.dormitory_system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.StudentGrade;
import com.gdut.dormitory_system.entity.vo.QueryStudentGradeVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zwj
 * @Date: 2022/7/28 16:24
 * @Description:
 */
public interface StudentGradeDao extends BaseMapper<StudentGrade> {

    PageInfo<StudentGrade> selectAllStudentGrade(PageInfo<StudentGrade> page, @Param("queryStudentGradeVO") QueryStudentGradeVo queryStudentGradeVO);

}
