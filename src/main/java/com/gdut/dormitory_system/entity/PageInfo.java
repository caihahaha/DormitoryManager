package com.gdut.dormitory_system.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Builder;
import lombok.Data;

/**
 * @PackgeName: com.gdut.dormitory_system.entity
 * @ClassName: PageInfo
 * @Author: csb
 * Date: 2022/7/26 23:28
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public class PageInfo<T> extends Page<T> {

    /**
     * 当前页面路径，用于页面跳转
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public PageInfo(long current, long size) {
        super(current, size);
    }
}
