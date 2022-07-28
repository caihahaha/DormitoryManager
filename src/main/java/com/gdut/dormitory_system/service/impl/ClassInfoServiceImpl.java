package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.dormitory_system.dao.ClassInfoDao;
import com.gdut.dormitory_system.entity.ClassInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.ClassInfoService;
import com.sun.corba.se.spi.ior.IdentifiableFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.service.impl
 * @ClassName: ClassInfoServiceImpl
 * @Author: csb
 * Date: 2022/7/27 15:58
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoDao classInfoDao;

    @Override
    public PageInfo<ClassInfo> findClassInfoPage(PageInfo<ClassInfo> page, String code, String className, String counsellor) {
        QueryWrapper<ClassInfo> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(code)) {
            wrapper.eq("code", code);
        }
        if (!StringUtils.isEmpty(className)) {
            wrapper.like("name", className);
        }
        if (!StringUtils.isEmpty(counsellor)) {
            wrapper.like("counsellor", counsellor);
        }
        return classInfoDao.selectPage(page, wrapper);
    }

    @Override
    public int addClassInfo(ClassInfo classInfo) {
        return classInfoDao.insert(classInfo);
    }

    @Override
    public int updateClassInfoById(ClassInfo classInfo) {
        return classInfoDao.updateById(classInfo);
    }

    @Override
    public int deleteClassInfoById(Integer id) {
        return classInfoDao.deleteById(id);
    }

    @Override
    public List<ClassInfo> findAllClassInfo() {
        return classInfoDao.selectList(null);
    }
}
