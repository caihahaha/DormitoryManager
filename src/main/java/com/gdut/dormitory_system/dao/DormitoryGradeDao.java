package com.gdut.dormitory_system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.dormitory_system.entity.DormitoryGrade;
import com.gdut.dormitory_system.entity.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @PackgeName: com.gdut.dormitory_system.dao
 * @ClassName: DormitoryGradeDao
 * @Author: csb
 * Date: 2022/7/28 17:49
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public interface DormitoryGradeDao extends BaseMapper<DormitoryGrade> {

    PageInfo<DormitoryGrade> selectDormitoryGradePage(PageInfo<DormitoryGrade> page, @Param("code") String code, @Param("location") String location);
}
