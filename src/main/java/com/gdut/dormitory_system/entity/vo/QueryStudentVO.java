package com.gdut.dormitory_system.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackgeName: com.gdut.dormitory_system.entity.vo
 * @ClassName: QueryStudentVO
 * @Author: csb
 * Date: 2022/7/26 17:02
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryStudentVO {

    private String name;

    private String studentCode;

    private String classCode;

    private String className;
}
