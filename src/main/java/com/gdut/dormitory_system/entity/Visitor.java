package com.gdut.dormitory_system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: Visitor
 * @Author: csb
 * Date: 2022/7/25 12:44
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "visitor")
public class Visitor {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String phone;

    private String dormitoryCode;

    private String dormitoryLocation;

    /** 创建时间 */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime ;
}
