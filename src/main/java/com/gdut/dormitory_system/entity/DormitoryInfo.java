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
 * @ClassName: DormitoryInfo
 * @Author: csb
 * Date: 2022/7/25 12:37
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "dormitory_info")
public class DormitoryInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String code;

    private String dormitoryLocation;

    private Integer bedTotal;

    private Integer bedUsed;

    private Integer adminId;
}
