package com.gdut.dormitory_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: Admin
 * @Author: csb
 * Date: 2022/7/25 12:24
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "admin")
public class Admin {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String phone;

    private Integer power;

    private String description;
}
