package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/23  16:24
 * version:     v1.0
 * describe：
 */
public class RequestManager {
    private HttpRequest request;
    private IRequestMethod requestMethod;

    public RequestManager(HttpRequest request, IRequestMethod requestMethod) {
        this.request = request;
        this.requestMethod = requestMethod;
    }

    public void get() {
        requestMethod.get(request);
    }

    public void post() {
        requestMethod.post(request);
    }
}
