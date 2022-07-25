package com.gdut.dormitory_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: Student
 * @Author: csb
 * Date: 2022/7/25 12:41
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "student")
public class Student {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private String sex;

    private Integer age;

    private String phone;

    private Integer classId;

    private Integer dormitoryId;
}
