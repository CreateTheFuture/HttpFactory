package com.adair.httpfactory.callback;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/17  17:29
 * version:     v1.0
 * describe：   请求成功回调接口
 */
public interface ISuccessCallback<T> {

    void onSuccess(T t);
}
