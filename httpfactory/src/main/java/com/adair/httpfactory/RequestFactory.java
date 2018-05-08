package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/8  15:58
 * version:     v1.0
 * describe：
 */
public class RequestFactory {

    private static IRequestManager requestManager;

    public static void init(IRequestManager manager) {
        if (requestManager == null) {
            requestManager = manager;
        } else {
            throw new RuntimeException("requestManager had initialized....");
        }
    }

    public static IRequestManager getRequestManager() {
        if (requestManager != null) {
            return requestManager;
        } else {
            throw new RuntimeException("requestManager is not  initialized....");
        }
    }
}
