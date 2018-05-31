package com.adair.httpfactory;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/23  14:11
 * version:     v1.0
 * describe：
 */
public class HttpRequest {

    //请求地址
    private String url;
    //头部配置
    private Map<String, Object> headers;
    //参数
    private Map<String, Object> params;
    //回调
    private Callback callback;

    private HttpRequest() {
    }

    private HttpRequest(HttpRequest httpRequest) {
        this.url = httpRequest.url;
        this.headers = httpRequest.headers;
        this.params = httpRequest.params;
        this.callback = httpRequest.callback;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static class Builder {
        private String url;//请求地址
        private Map<String, Object> headers;//头部配置
        private Map<String, Object> params;//参数
        private Callback callback;//回调

        public Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder header(@NonNull String key, String value) {
            if (headers == null) {
                headers = new HashMap<>();
            }
            this.headers.put(key, value);
            return this;
        }

        public Builder headers(@NonNull Map<String, String> headerMap) {
            if (headers == null) {
                headers = new HashMap<>();
            }
            this.headers.putAll(headerMap);
            return this;
        }

        public Builder param(@NonNull String key, Object value) {
            if (params == null) {
                params = new HashMap<>();
            }
            this.params.put(key, value);
            return this;
        }

        public Builder params(@NonNull Map<String, Object> paramMap) {
            if (params == null) {
                params = new HashMap<>();
            }
            this.params.putAll(paramMap);
            return this;
        }

        public Builder callback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public RequestManager build() {
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setUrl(url);
            httpRequest.setHeaders(headers);
            httpRequest.setParams(params);
            httpRequest.setCallback(callback);
            return new RequestManager(httpRequest, RequestMethodFactory.getRequestManager());
        }
    }

}
