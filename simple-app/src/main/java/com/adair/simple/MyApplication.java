package com.adair.simple;

import android.app.Application;

import com.adair.httpfactory.RequestFactory;

/**
 * package：    com.adair.simple
 * author：     XuShuai
 * date：       2018/5/8  16:04
 * version:     v1.0
 * describe：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RequestFactory.init(OkHttpRequestManager.getInstance());
    }
}
