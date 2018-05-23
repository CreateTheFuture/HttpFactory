package com.adair.httpfactory;

import android.os.Looper;
import android.support.annotation.NonNull;

import com.adair.httpfactory.callback.IEndCallback;
import com.adair.httpfactory.callback.IFailureCallback;
import com.adair.httpfactory.callback.IStartCallback;
import com.adair.httpfactory.callback.ISuccessCallback;

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

    private String url;//请求地址
    private Map<String, Object> headers;//头部配置
    private Map<String, Object> params;//参数
    private IStartCallback startCallback;//请求开始回调
    private ISuccessCallback successCallback;//请求成功回调
    private IFailureCallback failureCallback;//请求失败回调
    private IEndCallback endCallback;//请求结束后的回调
    private Looper handler;
    private HttpRequest() {
    }

    private HttpRequest(HttpRequest httpRequest) {
        this.url = httpRequest.url;
        this.headers = httpRequest.headers;
        this.params = httpRequest.params;
        handler = Looper.getMainLooper();
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

    public IStartCallback getStartCallback() {
        return startCallback;
    }

    public void setStartCallback(IStartCallback startCallback) {
        this.startCallback = startCallback;
    }

    public ISuccessCallback getSuccessCallback() {
        return successCallback;
    }

    public void setSuccessCallback(ISuccessCallback successCallback) {
        this.successCallback = successCallback;
    }

    public IFailureCallback getFailureCallback() {
        return failureCallback;
    }

    public void setFailureCallback(IFailureCallback failureCallback) {
        this.failureCallback = failureCallback;
    }

    public IEndCallback getEndCallback() {
        return endCallback;
    }

    public void setEndCallback(IEndCallback endCallback) {
        this.endCallback = endCallback;
    }


    public static class Builder {
        private String url;//请求地址
        private Map<String, Object> headers;//头部配置
        private Map<String, Object> params;//参数
        private IStartCallback startCallback;//请求开始回调
        private ISuccessCallback successCallback;//请求成功回调
        private IFailureCallback failureCallback;//请求失败回调
        private IEndCallback endCallback;//请求结束后的回调

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

        public Builder start(IStartCallback startCallback) {
            this.startCallback = startCallback;
            return this;
        }

        public Builder success(ISuccessCallback successCallback) {
            this.successCallback = successCallback;
            return this;
        }

        public Builder failure(IFailureCallback failureCallback) {
            this.failureCallback = failureCallback;
            return this;
        }

        public Builder end(IEndCallback endCallback) {
            this.endCallback = endCallback;
            return this;
        }

        public RequestManager build() {
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setUrl(url);
            httpRequest.setHeaders(headers);
            httpRequest.setParams(params);
            httpRequest.setStartCallback(startCallback);
            httpRequest.setSuccessCallback(successCallback);
            httpRequest.setFailureCallback(failureCallback);
            httpRequest.setEndCallback(endCallback);
            return new RequestManager(httpRequest, RequestMethodFactory.getRequestManager());
        }
    }

}
