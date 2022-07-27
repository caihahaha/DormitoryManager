package com.gdut.dormitory_system.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zwj
 * @Date: 2022/7/28 0:24
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryAdminVO {

    private String name;

    private String description;
}
