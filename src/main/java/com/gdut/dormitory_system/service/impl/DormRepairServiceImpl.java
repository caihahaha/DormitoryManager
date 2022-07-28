package com.gdut.dormitory_system.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.dormitory_system.dao.DormRepairDao;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.DormitoryRepair;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DormRepairServiceImpl implements DormRepairService {

    @Autowired
    private DormRepairDao dormRepairDao;

    @Override
    public PageInfo<DormitoryRepair> findDormRepair(Integer dormitoryId, Integer studentId, Integer pageNum , Integer pageSize) {
        QueryWrapper<DormitoryRepair> wrapper = new QueryWrapper<>() ;
        PageInfo<DormitoryRepair> page ;
        page = new  PageInfo<>(pageNum,pageSize);
        if(studentId!=null&&studentId!=0){
            wrapper.eq("student_id",studentId);
        }
        if(dormitoryId!=null&&dormitoryId!=0){
            wrapper.eq("dormitory_id",dormitoryId);
        }

        dormRepairDao.selectPage(page,wrapper);
        return  page;

    }

    @Override
    public int addDormRepair(DormitoryRepair dormitoryRepair) {
        dormitoryRepair.setCreatedTime(DateTime.now());
        dormitoryRepair.setUpdatedTime(DateTime.now());
        return dormRepairDao.insert(dormitoryRepair);
    }

    @Override
    public int deleteDormRepair(Integer id) {
        int res = dormRepairDao.deleteById(id);
        return res;
    }

    @Override
    public DormitoryRepair findOneById(Integer id) {
        DormitoryRepair dormitoryRepair =dormRepairDao.selectById(id);
        return dormitoryRepair;
    }

    @Override
    public int updateDormRepair(DormitoryRepair dormitoryRepair) {
        dormitoryRepair.setUpdatedTime(DateTime.now());
        int res =dormRepairDao.updateById(dormitoryRepair);
        return  res;
    }

    @Override
    public List<DormitoryRepair> getAll() {

        return dormRepairDao.selectList(null);
    }

}
