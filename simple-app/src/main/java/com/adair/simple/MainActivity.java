package com.adair.simple;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.adair.httpfactory.Callback;
import com.adair.httpfactory.HttpRequest;

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
                        .callback(new Callback<String>() {

                            @Override
                            public void onSuccess(String s) {

                            }

                            @Override
                            public void onFailure(Throwable throwable, @NonNull Boolean isNetworkError) {

                            }
                        })
                        .build()
                        .get();
                break;
        }
    }
}
