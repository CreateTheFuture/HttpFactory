package com.adair.httpfactory;

/**
 * package：    com.adair.httpfactory
 * author：     XuShuai
 * date：       2018/5/31  10:19
 * version:     v1.0
 * describe：   ICallback实现类，对onStart()方法和onFinish()方法做空实现，需要调用时需要再重写方法
 */
public abstract class Callback<T> implements ICallback<T> {
    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }
}
