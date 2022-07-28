package com.gdut.dormitory_system.service.impl;

import com.gdut.dormitory_system.dao.DormitoryGradeDao;
import com.gdut.dormitory_system.entity.DormitoryGrade;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.DormitoryGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.service.impl
 * @ClassName: DormitoryGradeServiceImpl
 * @Author: csb
 * Date: 2022/7/28 17:51
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Service
public class DormitoryGradeServiceImpl implements DormitoryGradeService {

    @Autowired
    private DormitoryGradeDao dormitoryGradeDao;

    @Override
    public PageInfo<DormitoryGrade> findDormitoryGradePage(PageInfo<DormitoryGrade> page, String code, String location) {
        return dormitoryGradeDao.selectDormitoryGradePage(page, code, location);
    }

    @Override
    public List<DormitoryGrade> findDormitoryGradeList() {
        return dormitoryGradeDao.selectList(null);
    }

    @Override
    public int addDormitoryGrade(DormitoryGrade dormitoryGrade) {
        return dormitoryGradeDao.insert(dormitoryGrade);
    }

    @Override
    public int updateDormitoryGrade(DormitoryGrade dormitoryGrade) {
        return dormitoryGradeDao.updateById(dormitoryGrade);
    }

    @Override
    public int deleteDormitoryGradeById(Integer id) {
        return dormitoryGradeDao.deleteById(id);
    }

    @Override
    public DormitoryGrade findDormitoryGradeById(Integer id) {
        return dormitoryGradeDao.selectById(id);
    }
}
