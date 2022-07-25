package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * @PackgeName: com.gdut.dormitory_system.service
 * @ClassName: AdminService
 * @Author: csb
 * Date: 2022/7/25 17:00
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public interface AdminService {

    Admin findAdminByUsernameAndPwd(String username, String password);

}
