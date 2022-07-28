package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.dormitory_system.dao.StudentCleanDao;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;
import com.gdut.dormitory_system.service.StudentCleanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zwj
 * @Date: 2022/7/28 9:52
 * @Description:
 */
@Service
public class StudentCleanServiceImpl implements StudentCleanService {

    @Autowired
    private StudentCleanDao studentCleanDao;
    @Override
    public PageInfo<StudentCleanVo> findPageInfo(StudentCleanVo studentCleanVo, PageInfo<StudentCleanVo> pageInfo) {

        QueryWrapper<StudentCleanVo> queryWrapper = new QueryWrapper<>();

        if (studentCleanVo.getStudentId() != null && studentCleanVo.getStudentId() != 0) {
            queryWrapper.like("student_id", studentCleanVo.getStudentId());
        }

        if (!StringUtils.isEmpty(studentCleanVo.getName())) {
            queryWrapper.like("name", studentCleanVo.getName());
        }

        if (studentCleanVo.getDormitoryId() != null && studentCleanVo.getDormitoryId() != 0) {
            queryWrapper.like("dormitory_id", studentCleanVo.getDormitoryId());
        }

        pageInfo = studentCleanDao.findPageInfo(studentCleanVo, pageInfo);
        return pageInfo;
    }
}
