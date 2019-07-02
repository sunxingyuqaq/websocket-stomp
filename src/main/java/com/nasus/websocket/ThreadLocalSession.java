package com.nasus.websocket;

import org.springframework.util.StringUtils;

/**
 * @author Xingyu Sun
 * @date 2019/3/7 9:20
 */
public class ThreadLocalSession {

    private static final ThreadLocal<String> MAP = new InheritableThreadLocal<>();

    public static String get(){
        if(StringUtils.isEmpty(MAP.get())){
            MAP.set("default");
        }
        return MAP.get();
    }

    public static void setMap(String value) {
        MAP.set(value);
    }

    public static void remove(){
        MAP.remove();
    }
}
