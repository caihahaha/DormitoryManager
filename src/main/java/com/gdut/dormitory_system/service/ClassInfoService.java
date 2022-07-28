package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.ClassInfo;
import com.gdut.dormitory_system.entity.PageInfo;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.service
 * @ClassName: ClassInfoService
 * @Author: csb
 * Date: 2022/7/27 15:55
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public interface ClassInfoService {

    PageInfo<ClassInfo> findClassInfoPage(PageInfo<ClassInfo> page, String code, String className, String counsellor);

    int addClassInfo(ClassInfo classInfo);

    int updateClassInfoById(ClassInfo classInfo);

    int deleteClassInfoById(Integer id);

    List<ClassInfo> findAllClassInfo();
}
