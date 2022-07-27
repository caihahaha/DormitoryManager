package com.gdut.dormitory_system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.entity.LoginTicket;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.vo.QueryAdminVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    LoginTicket findAdminByTicket(String ticket);

    Admin findAdminById(Integer adminId);

    Map<String, String> login(String username, String password, Integer expiredSeconds);

    int addAdmin(Admin admin);

    int deleteAdminById(Integer adminId);

    int updateAdmin(Admin admin);

    PageInfo<Admin> findPageInfo(QueryAdminVO queryAdminVO, PageInfo<Admin> page);

    void loginOut(String ticket);

    List<Admin> getAll();
}
