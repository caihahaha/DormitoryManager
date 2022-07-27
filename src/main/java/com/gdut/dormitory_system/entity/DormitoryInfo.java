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
    private Integer id;//宿舍id主键

    private String code;//宿舍编码

    private String dormitoryLocation;//宿舍位置

    private Integer bedTotal;//宿舍床位

    private Integer bedUsed;//宿舍已使用床位

    private String adminName;//宿舍管理员姓名
}
