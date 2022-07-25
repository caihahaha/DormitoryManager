package com.gdut.dormitory_system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: LoginTicket
 * @Author: csb
 * Date: 2022/7/25 23:39
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginTicket implements Serializable {

    private Integer adminId;

    private String ticket;

    private Integer status;

    private Date expired;
}
