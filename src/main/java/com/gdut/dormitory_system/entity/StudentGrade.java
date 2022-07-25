package com.gdut.dormitory_system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: StudentGrade
 * @Author: csb
 * Date: 2022/7/25 12:43
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "student_grade")
public class StudentGrade {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer studentId;

    private Integer classId;

    private Integer dormitoryId;

    private Integer grade;

    /** 创建时间 */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime ;

    /** 更新时间 */
    @TableField(value = "updated_time", fill = FieldFill.UPDATE)
    private Date updatedTime ;
}
