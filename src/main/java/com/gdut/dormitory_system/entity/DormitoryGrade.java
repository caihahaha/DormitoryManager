package com.gdut.dormitory_system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: DormitoryGrade
 * @Author: csb
 * Date: 2022/7/25 12:34
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "dormitory_grade")
public class DormitoryGrade {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer dormitoryId;

    private Integer grade;

    /** 创建时间 */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime ;
    /** 更新时间 */
    @TableField(value = "updated_time", fill = FieldFill.UPDATE)
    private Date updatedTime ;

    @TableField(exist = false)
    private DormitoryInfo dormitoryInfo;
}
