package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/8  15:29
 * version:     v1. 0
 * describe：   请求成功/失败的接口
 */
public interface IRequestCallback<T> {
    void onSuccess(T t);

    void onFailure(Throwable throwable);
}
