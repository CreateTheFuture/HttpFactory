package com.adair.simple;

import android.util.Log;

import com.adair.httpfactory.IRequestCallback;
import com.adair.httpfactory.IRequestManager;

/**
 * package：    com.adair.simple
 * author：     XuShuai
 * date：       2018/5/8  16:07
 * version:     v1.0
 * describe：
 */
public class OkHttpRequestManager implements IRequestManager {
    private static final OkHttpRequestManager ourInstance = new OkHttpRequestManager();

    private OkHttpRequestManager() {
    }


    public static OkHttpRequestManager getInstance() {
        return ourInstance;
    }

    @Override
    public void get(String url, IRequestCallback requestCallback) {

    }

    @Override
    public void post(String url, String requestBodyJson, IRequestCallback requestCallback) {

    }

    @Override
    public void put(String url, String requestBodyJson, IRequestCallback requestCallback) {

    }

    @Override
    public void delete(String url, String requestBodyJson, IRequestCallback requestCallback) {

    }
}
