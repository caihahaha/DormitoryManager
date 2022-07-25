package com.gdut.dormitory_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gdut.dormitory_system.dao")
public class DormitorySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitorySystemApplication.class, args);
    }

}
