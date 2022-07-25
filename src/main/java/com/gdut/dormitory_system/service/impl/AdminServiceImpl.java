package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.dormitory_system.dao.AdminDao;
import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackgeName: com.gdut.dormitory_system.service.impl
 * @ClassName: AdminServiceImpl
 * @Author: csb
 * Date: 2022/7/25 17:02
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findAdminByUsernameAndPwd(String username, String password) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", MD5Utils.MD5EncodeUtf8(password));
        return adminDao.selectOne(wrapper);
    }
}
