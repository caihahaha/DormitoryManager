package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.DormitoryRepair;
import com.gdut.dormitory_system.entity.PageInfo;

import java.util.List;

public interface DormRepairService {
    PageInfo<DormitoryRepair> findDormRepair(Integer dormitoryId, Integer studentId, Integer pageNum, Integer pageSize);

    int addDormRepair(DormitoryRepair dormitoryRepair);

    int deleteDormRepair(Integer id);

    DormitoryRepair findOneById(Integer id);

    int updateDormRepair(DormitoryRepair dormitoryRepair);

    List<DormitoryRepair> getAll();

}
