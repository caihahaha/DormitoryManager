package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.DormitoryGrade;
import com.gdut.dormitory_system.entity.PageInfo;

import java.util.List;

/**
 * @PackgeName: com.gdut.dormitory_system.service
 * @ClassName: DormitoryGradeService
 * @Author: csb
 * Date: 2022/7/28 17:51
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public interface DormitoryGradeService {

    PageInfo<DormitoryGrade> findDormitoryGradePage(PageInfo<DormitoryGrade> page, String code, String location);

    List<DormitoryGrade> findDormitoryGradeList();

    int addDormitoryGrade(DormitoryGrade dormitoryGrade);

    int updateDormitoryGrade(DormitoryGrade dormitoryGrade);

    int deleteDormitoryGradeById(Integer id);

    DormitoryGrade findDormitoryGradeById(Integer id);
}
