package com.gdut.dormitory_system.util;

/**
 * @PackgeName: com.gdut.dormitory_system.util
 * @ClassName: RedisUtils
 * @Author: csb
 * Date: 2022/7/25 23:43
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public class RedisKeyUtils {

    private static final String SPLIT = ":";

    private static final String PREFIX_TICKET = "ticket";

    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }
}
