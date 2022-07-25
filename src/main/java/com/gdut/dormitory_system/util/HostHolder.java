package com.gdut.dormitory_system.util;

import com.gdut.dormitory_system.entity.Admin;
import org.springframework.stereotype.Component;

/**
 * @PackgeName: com.gdut.dormitory_system.util
 * @ClassName: HostHolder
 * @Author: csb
 * Date: 2022/7/25 23:52
 * project name: dormitory_manager
 * @Version:
 * @Description:
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
