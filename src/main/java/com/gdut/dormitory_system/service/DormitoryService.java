package com.gdut.dormitory_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.vo.QueryDormitoryStudentVo;

import java.util.List;


public interface DormitoryService {
    //添加宿舍
     Integer addDormitory(DormitoryInfo dormitoryInfo) ;
    //    带条件的分页
    PageInfo<DormitoryInfo> findDormitory(String  adminName, String code, String dormitoryLocation,
                                          Integer pageNum, Integer pageSize);
    //查询全部
     List<DormitoryInfo> findAll();

     //根据id删除
    Integer deleteById(Integer dormitoryId);

    //根据code查询
    List<DormitoryInfo> findByCode(String code);
    //根据code查询
    DormitoryInfo findOneByCode(String code);
    //根据id查询
    DormitoryInfo findDormitoryById(Integer id);

    //更新宿舍
    int updateDormitory(DormitoryInfo dormitoryInfo);

    //查询每个宿舍对应的学生
    List<QueryDormitoryStudentVo> findDormitoryStudent(QueryDormitoryStudentVo queryDormitoryStudentVo);
}
