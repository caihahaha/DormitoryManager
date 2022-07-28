package com.gdut.dormitory_system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.StudentGrade;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/28 10:16
 * @Description:
 */
public interface StudentCleanDao extends BaseMapper<StudentCleanVo> {

    @Select({"<script>"
            +"SELECT stg.id,stg.student_id,stu.name,stg.grade,stg.class_id,stg.dormitory_id,stg.created_time,stg.created_time "
            +"FROM student_grade stg LEFT JOIN student stu on stg.student_id = stu.code"
            +"WHERE 1=1"
            // +"when test= ''"
            +"</script>"})
    PageInfo<StudentCleanVo> findPageInfo(StudentCleanVo studentCleanVo, PageInfo<StudentCleanVo> pageInfo);

    // List<StudentCleanVo> getStudentCleanList()
}
