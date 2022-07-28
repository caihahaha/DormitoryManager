package com.gdut.dormitory_system.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zwj
 * @Date: 2022/7/28 16:48
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryStudentGradeVo {

    private Integer studentId;

    private String name;

    private Integer dormitoryId;
}
