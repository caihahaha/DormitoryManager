package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;

/**
 * @Author: zwj
 * @Date: 2022/7/28 9:51
 * @Description:
 */
public interface StudentCleanService {

    PageInfo<StudentCleanVo> findPageInfo(StudentCleanVo studentCleanVo, PageInfo<StudentCleanVo> pageInfo);
}
