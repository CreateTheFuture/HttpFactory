package com.adair.simple;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.adair.httpfactory.HttpRequest;
import com.adair.httpfactory.IRequestMethod;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * package：    com.adair.simple
 * author：     XuShuai
 * date：       2018/5/23  16:31
 * version:     v1.0
 * describe：
 */
public class OkHttpRequestMethod implements IRequestMethod {
    private static final String TAG = "OkHttpRequestMethod";
    private Handler handler;

    public OkHttpRequestMethod() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void get(final HttpRequest request) {
        if (request.getStartCallback() != null) {
            request.getStartCallback().onStart();
        }
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象
        Request OkHttpRequest = new Request.Builder()
                .url(request.getUrl())//请求接口。如果需要传参拼接到接口后面。
                .build();//创建Request 对象

        client.newCall(OkHttpRequest).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                e.printStackTrace();
                Log.d(TAG, "onFailure()");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(request.getFailureCallback() !=null){
                            request.getFailureCallback().onFailure(e,call);
                        }
                        if (request.getEndCallback() != null) {
                            request.getEndCallback().onEnd();
                        }
                    }
                });


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d(TAG, "onResponse()");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(request.getSuccessCallback() !=null){
                            try {
                                request.getSuccessCallback().onSuccess(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (request.getEndCallback() != null) {
                            request.getEndCallback().onEnd();
                        }
                    }
                });

            }
        });
    }

    @Override
    public void post(HttpRequest request) {
        if (request.getStartCallback() != null) {
            request.getStartCallback().onStart();
        }
        Log.e(TAG, "11111111111111");

        if (request.getEndCallback() != null) {
            request.getEndCallback().onEnd();
        }

    }

    @Override
    public void put(HttpRequest request) {

    }

    @Override
    public void delete(HttpRequest request) {

    }
}
