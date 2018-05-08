package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/8  15:27
 * version:     v1.0
 * describe：   此接口提供的是http请求的通用接口方法，可以使用volley实现，也可是okHttp实现,get方法包含请求地址，返回接口,post/put/delete还包含一个请求体参数
 */
public interface IRequestManager {


    void get(String url, IRequestCallback requestCallback);

    void post(String url, String requestBodyJson, IRequestCallback requestCallback);

    void put(String url, String requestBodyJson, IRequestCallback requestCallback);

    void delete(String url, String requestBodyJson, IRequestCallback requestCallback);
}
