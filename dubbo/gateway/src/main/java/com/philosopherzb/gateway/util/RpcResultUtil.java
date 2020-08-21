package com.philosopherzb.gateway.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
public class RpcResultUtil {

    public static Object fixRpcResultClass(Object object) {
        if (object == null) {
            return null;
        }
        if ((object instanceof Map)) {
            Map objMap = (Map) object;
            objMap.remove("class");
            Set keys = objMap.keySet();
            for (Object key : keys) {
                Object value = objMap.get(key);
                Object fixValue = fixRpcResultClass(value);
                objMap.put(key, fixValue);
            }
            return objMap;
        }
        if ((object instanceof Collection)) {
            Collection c = (Collection) object;
            for (Object obj : c) {
                fixRpcResultClass(obj);
            }
            return c;
        }
        if (object.getClass().isArray()) {
            Object[] objs = (Object[]) object;
            for (Object obj : objs) {
                fixRpcResultClass(obj);
            }
            return objs;
        }
        return object;
    }
}
