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
 * @ClassName: ClassInfo
 * @Author: csb
 * Date: 2022/7/25 12:33
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "class_info")
public class ClassInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private String counsellor;


}
