package com.adair.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.adair.httpfactory.HttpRequest;
import com.adair.httpfactory.callback.IEndCallback;
import com.adair.httpfactory.callback.IFailureCallback;
import com.adair.httpfactory.callback.IStartCallback;
import com.adair.httpfactory.callback.ISuccessCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn1:
                Toast.makeText(MainActivity.this, "开始请求", Toast.LENGTH_LONG).show();
                new HttpRequest.Builder()
                        .url("http://www.baidu.com")
                        .start(new IStartCallback() {
                            @Override
                            public void onStart() {
                                Log.d(TAG, "onStart() called");

                            }
                        })
                        .success(new ISuccessCallback<String>() {
                            @Override
                            public void onSuccess(String response) {
                                Log.d(TAG, "onSuccess() called with: response = [" + response +
                                        "]");
                            }
                        })
                        .failure(new IFailureCallback() {
                            @Override
                            public void onFailure(Object... values) {
                                Log.d(TAG, "onFailure() called with: values = [" + values + "]");
//                                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_LONG).show();
                            }

                        })
                        .end(new IEndCallback() {
                            @Override
                            public void onEnd() {
                                Log.d(TAG, "onEnd() called");
//                                Toast.makeText(MainActivity.this, "请求结束", Toast.LENGTH_LONG).show();
                            }
                        })
                        .build()
                        .get();
                break;
        }
    }
}
