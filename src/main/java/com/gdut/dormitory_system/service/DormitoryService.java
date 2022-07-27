package com.gdut.dormitory_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.DormitoryInfo;

import java.util.List;


public interface DormitoryService {
    //添加宿舍
     Integer addDormitory(DormitoryInfo dormitoryInfo) ;
    //    带条件的分页
    IPage<DormitoryInfo> findDormitory(String  adminName, Integer id, String dormitoryLocation,
                                       Integer pageIndex, Integer pageSize);
    //查询全部
     List<DormitoryInfo> findAll();

     //根据id删除
    Integer deleteById(Integer dormitoryId);

    //根据code查询
    List<DormitoryInfo> findByCode(Integer code);
}
