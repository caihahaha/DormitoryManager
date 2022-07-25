package com.gdut.dormitory_system.dao.config;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @PackgeName: com.gdut.dormitory_system.dao.config
 * @ClassName: MyMetaObjectHandler
 * @Author: csb
 * Date: 2022/7/25 16:40
 * project name: dormitory_manager
 * @Version:
 * @Description:    mybatis-plus 自动填充创建时间和更新时间
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "createdTime", DateUtil.date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        this.fillStrategy(metaObject, "updatedTime", DateUtil.date());

    }
}
