package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/23  19:50
 * version:     v1.0
 * describe：
 */
public interface ICallback<T> {
    void onStart();

    void onSuccess(T t);

    void onFailure(Throwable throwable);

    void onFinish();
}
