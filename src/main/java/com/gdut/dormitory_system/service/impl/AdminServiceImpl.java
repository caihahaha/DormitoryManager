package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.dao.AdminDao;
import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.entity.LoginTicket;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.CommonUtils;
import com.gdut.dormitory_system.util.MD5Utils;
import com.gdut.dormitory_system.util.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Admin findAdminByUsernameAndPwd(String username, String password) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", MD5Utils.MD5EncodeUtf8(password));
        return adminDao.selectOne(wrapper);
    }

    @Override
    public LoginTicket findAdminByTicket(String ticket) {
        String ticketKey = RedisKeyUtils.getTicketKey(ticket);
        return (LoginTicket) redisTemplate.opsForValue().get(ticketKey);
    }

    @Override
    public Admin findAdminById(Integer adminId) {
        return adminDao.selectById(adminId);
    }

    @Override
    public Map<String, String> login(String username, String password, Integer expiredSeconds) {
        Admin admin = findAdminByUsernameAndPwd(username, password);
        Map<String, String> resultMap = new HashMap<>();
        if (admin != null) {
            LoginTicket loginTicket = new LoginTicket(admin.getId(), CommonUtils.generateUUID(), 1, new Date(System.currentTimeMillis() + expiredSeconds * 1000));
            resultMap.put("ticket", loginTicket.getTicket());
            String ticketKey = RedisKeyUtils.getTicketKey(loginTicket.getTicket());
            redisTemplate.opsForValue().set(ticketKey, loginTicket);
        }else {
            resultMap.put("msg", "用户名或密码错误");
        }
        return resultMap;
    }

    @Override
    public void loginOut(String ticket) {
        String redisKey = RedisKeyUtils.getTicketKey(ticket);
        LoginTicket loginTicket = (LoginTicket) redisTemplate.opsForValue().get(redisKey);
        loginTicket.setStatus(0);
        redisTemplate.opsForValue().set(redisKey, loginTicket);
    }

    @Override
    public int addAdmin(Admin admin) {

        return adminDao.insert(admin);
    }

    @Override
    public int deleteAdminById(Integer adminId) {
        return adminDao.deleteById(adminId);
    }

    @Override
    public int updateAdmin(Admin admin) {
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", admin.getId());
        return adminDao.update(admin, updateWrapper);
    }

    @Override
    public PageInfo<Admin> findPageInfo(Admin admin, PageInfo<Admin> pageInfo) {
        // Page(pageIndex, pageSize);
        // List<Admin> pageInfo = adminDao.se
        // Page<Admin> pageInfo = new Page<>(pageIndex, pageSize);
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>(admin);
        pageInfo = adminDao.selectPage(pageInfo, queryWrapper);
        for (Admin admin0 : pageInfo.getRecords()) {
            System.out.println(admin0.getName());
        }
        return pageInfo;
    }

    @Override
    public List<Admin> getAll() {

        List<Admin> adminList = adminDao.selectList(null);

        return adminList;
    }
}
