package com.kang.kangtemplate.utils.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ThreadLocal 工具类，用于封装线程上下文数据管理。
 * @author: liukang
 * @date: 2024/12/15 19:25:23
 */
public class ThreadLocalUtil {

    /**
     * ThreadLocal 变量，用于存储线程局部变量。
     */
    private static final ThreadLocal<Map<String, Object>> THREAD_CONTEXT = ThreadLocal.withInitial(HashMap::new);

    /**
     * 设置线程上下文中的数据。
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, Object value) {
        THREAD_CONTEXT.get().put(key, value);
    }

    /**
     * 获取线程上下文中的数据。
     *
     * @param key 键
     * @return 当前线程上下文中的值
     */
    public static Object get(String key) {
        return THREAD_CONTEXT.get().get(key);
    }

    /**
     * 移除线程上下文中的指定键值对。
     *
     * @param key 键
     */
    public static void remove(String key) {
        THREAD_CONTEXT.get().remove(key);
    }

    /**
     * 清空线程上下文。
     */
    public static void clear() {
        THREAD_CONTEXT.remove();
    }
}
