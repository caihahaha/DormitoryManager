package com.gdut.dormitory_system.util;

import java.util.UUID;

/**
 * @PackgeName: com.gdut.dormitory_system.util
 * @ClassName: CommonUtils
 * @Author: csb
 * Date: 2022/7/25 23:50
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public class CommonUtils {

    /**
     * 生成随机字符串
     * @return  随机字符串
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
