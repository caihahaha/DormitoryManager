package com.gdut.dormitory_system.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @PackgeName: com.gdut.dormitory_system.util
 * @ClassName: JSONUtils
 * @Author: csb
 * Date: 2022/7/25 16:45
 * project name: dormitory_manager
 * @Version:
 * @Description:
 */
public class JSONUtils {

    public static String getJSONString(int code, String msg, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if (map != null) {
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code, msg, null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code, null, null);
    }
}
