package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.dormitory_system.dao.StudentCleanDao;
import com.gdut.dormitory_system.dao.StudentGradeDao;
import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.StudentGrade;
import com.gdut.dormitory_system.entity.vo.QueryStudentGradeVo;
import com.gdut.dormitory_system.entity.vo.StudentCleanVo;
import com.gdut.dormitory_system.service.StudentCleanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/28 9:52
 * @Description:
 */
@Service
public class StudentCleanServiceImpl implements StudentCleanService {


    @Autowired
    private StudentGradeDao studentGradeDao;

    @Override
    public PageInfo<StudentGrade> findPageInfo(QueryStudentGradeVo queryStudentGradeVo, PageInfo<StudentGrade> pageInfo) {

        pageInfo = studentGradeDao.selectAllStudentGrade(pageInfo, queryStudentGradeVo);

        return pageInfo;
    }

    @Override
    public List<StudentGrade> getAll() {
        return studentGradeDao.selectList(null);
    }

    @Override
    public int addStudentGrade(StudentGrade studentGrade) {
        return studentGradeDao.insert(studentGrade);
    }

    @Override
    public int deleteStudentGrade(Integer id) {
        return studentGradeDao.deleteById(id);
    }

    @Override
    public int updateStudentGrade(StudentGrade studentGrade) {
        UpdateWrapper<StudentGrade> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", studentGrade.getId());
        return studentGradeDao.update(studentGrade, updateWrapper);
    }

    @Override
    public StudentGrade findStudentGradeById(Integer id) {
        // PageInfo<StudentGrade> pageInfo = new PageInfo<>(1,1);
        // QueryStudentGradeVo vo = new QueryStudentGradeVo();
        // vo.setStudentId(id);
        // StudentGrade studentGrade = studentGradeDao.selectAllStudentGrade(pageInfo, queryStudentGradeVo);
        return studentGradeDao.selectById(id);
    }
}
