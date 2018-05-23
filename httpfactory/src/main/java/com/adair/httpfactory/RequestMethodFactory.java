package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/8  15:58
 * version:     v1.0
 * describe：
 */
public class RequestMethodFactory {

    private static IRequestMethod requestMethod;

    public static void init(IRequestMethod manager) {
        if (requestMethod == null) {
            requestMethod = manager;
        } else {
            throw new RuntimeException("requestMethod had initialized....");
        }
    }

    public static IRequestMethod getRequestManager() {
        if (requestMethod != null) {
            return requestMethod;
        } else {
            throw new RuntimeException("requestMethod is not  initialized....");
        }
    }
}
