package com.gdut.dormitory_system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Student;
import com.gdut.dormitory_system.entity.vo.QueryStudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.dao
 * @ClassName: StudentDao
 * @Author: csb
 * Date: 2022/7/26 17:03
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public interface StudentDao extends BaseMapper<Student> {

    PageInfo<Student> selectAllStudent(PageInfo<Student> page, @Param("queryStudentVO") QueryStudentVO queryStudentVO);
}
