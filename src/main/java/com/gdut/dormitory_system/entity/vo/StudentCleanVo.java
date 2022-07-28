package com.gdut.dormitory_system.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: zwj
 * @Date: 2022/7/28 10:01
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCleanVo {

    private Integer id;

    private Integer studentId;

    private String name;

    private Integer classId;

    private Integer dormitoryId;

    private Integer grade;

    private Date createdTime ;

    private Date updatedTime ;
    
}
