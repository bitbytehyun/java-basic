package spring;

import java.util.HashMap;
import java.util.Map;

// 쓰레드 별 트랜젝션 관리
public class CustomTransactionSynchronizationManager {
    private static ThreadLocal<Map<Object, Object>> resources = new ThreadLocal<>();

    public static void bindResource(Object key, Object resource) {
        Map<Object, Object> map = resources.get();
        if (map == null) {
            map = new HashMap<>();
            resources.set(map);
        }
        map.put(key, resource);
    }

    public static Object getResource(Object key) {
        Map<Object, Object> map = resources.get();
        return (map != null) ? map.get(key) : null;
    }

    public static Object unbindResource(Object key) {
        Map<Object, Object> map = resources.get();
        if (map == null) {
            return null;
        }
        Object value = map.remove(key);
        if (map.isEmpty()) {
            resources.remove();
        }
        return value;
    }
}
