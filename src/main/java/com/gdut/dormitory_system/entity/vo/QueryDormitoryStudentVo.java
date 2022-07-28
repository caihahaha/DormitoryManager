package com.gdut.dormitory_system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gdut.dormitory_system.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryDormitoryStudentVo {

    @TableId(type = IdType.AUTO)
    private Integer id;//宿舍id主键

    private String code;//宿舍编码

    private String dormitoryLocation;//宿舍位置

    private Integer bedTotal;//宿舍床位

    private Integer bedUsed;//宿舍已使用床位

    private String adminName;//宿舍管理员姓名

    //每个宿舍对应的学生
    private List<Student> studentsList ;

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
