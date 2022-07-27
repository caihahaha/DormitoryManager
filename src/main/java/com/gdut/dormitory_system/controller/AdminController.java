package com.gdut.dormitory_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.entity.Admin;
import com.gdut.dormitory_system.service.AdminService;
import com.gdut.dormitory_system.util.HostHolder;
import com.gdut.dormitory_system.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zwj
 * @Date: 2022/7/26 12:26
 * @Description:
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HostHolder hostHolder;

    /**
     * 分页查询 admin 用户
     */
    @RequestMapping(value = "/findAdmin")
    public String findAdmin(String a_username, String a_describe, @RequestParam(defaultValue = "1") Integer pageIndex,
                            Integer a_id, @RequestParam(defaultValue = "3") Integer pageSize, Model model) {
        Admin admin = new Admin();
        admin.setUsername(a_username);
        admin.setId(a_id);
        admin.setDescription(a_describe);

        // 使用分页插件查找
        Page<Admin> ai = adminService.findPageInfo(admin, pageIndex, pageSize);
        model.addAttribute("ai", ai);
        model.addAttribute("admin", hostHolder.getAdmin());
        return "admin_list";
    }

    /**
     * 添加管理员信息
     */
    @PostMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(@RequestBody Admin admin) {
        admin.setPassword(MD5Utils.MD5EncodeUtf8(admin.getPassword()));
        int res = adminService.addAdmin(admin);
        return "admin_list";
    }

    /**
     * 根据管理员id删除管理员信息
     */
    @RequestMapping("/deleteAdmin") // 这里是否需要指明使用post，等一下看看前端如何请求
    @ResponseBody
    public String deleteAdminById(Integer adminId) {
        int res = adminService.deleteAdminById(adminId);
        return "admin_list";
    }

    /**
     * 修改管理员信息
     */
    @PostMapping("/updateAdmin")
    public String updateAdmin(Admin admin) {
        // 这里可以自动获取id吗
        System.out.println(admin.getId());
        admin.setPassword(MD5Utils.MD5EncodeUtf8(admin.getPassword()));
        int res = adminService.updateAdmin(admin);
        return "redirect:/findAdmin";
    }

    /**
     * 根据管理员id 搜索，将请求数据
     */
    @RequestMapping("/findAdminById")
    public String findAdminById(Model model) {
        Admin admin = hostHolder.getAdmin();
        model.addAttribute("admin", admin);
        return "admin_edit";
    }

}
