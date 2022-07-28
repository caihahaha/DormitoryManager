package com.gdut.dormitory_system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.vo.QueryDormitoryStudentVo;

import java.util.List;

public interface DormitoryDao extends BaseMapper<DormitoryInfo> {

    //查询每个宿舍对应的学生
    List<QueryDormitoryStudentVo> findDormitoryStudent(QueryDormitoryStudentVo queryDormitoryStudentVo);
}
