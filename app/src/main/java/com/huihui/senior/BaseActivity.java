package com.huihui.senior;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected String Title;


    protected void start(Class<?> cls, String title) {
        Intent intent = new Intent();
        intent.putExtra("title", title);
        intent.setClass(this, cls);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent!=null){

            String title = intent.getStringExtra("title");

            setTitle(title);
        }
    }

    public void startNewActivity(Class<?> cls) {

        start(cls, null);
    }
}
