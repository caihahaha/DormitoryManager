package com.gdut.dormitory_system.util;

import com.gdut.dormitory_system.entity.Admin;
import org.springframework.stereotype.Component;

/**
 * @Author: zwj
 * @Date: 2022/7/26 0:28
 * @Description: 持有用户信息，用于代替session对象
 */
@Component
public class HostHolder {
    private ThreadLocal<Admin> admins = new ThreadLocal<>();

    public void setAdmin(Admin admin) {
        admins.set(admin);
    }

    public Admin getAdmin() {
        return admins.get();
    }

    public void clear() {
        admins.remove();
    }
}
