package com.adair.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.adair.httpfactory.RequestCallback;
import com.adair.httpfactory.RequestFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
                RequestFactory.getRequestManager().get("", new RequestCallback<String>() {
                            @Override
                            public void onStart() {
                                super.onStart();
                            }

                            @Override
                            public void onSuccess(String s) {

                            }

                            @Override
                            public void onFailure(Throwable throwable) {

                            }

                            @Override
                            public void onEnd() {
                                super.onEnd();
                            }
                        }
                );
                break;
        }
    }
}
