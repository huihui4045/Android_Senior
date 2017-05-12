package com.huihui.senior.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected String mTitle;


    protected void start(Class<?> cls, String title) {
        Intent intent = new Intent();
        intent.putExtra("title", title);
        intent.setClass(this, cls);
        startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();

        if (intent != null) {

            mTitle = intent.getStringExtra("title");

            setTitle(mTitle);
        }
    }

    public void startNewActivity(Class<?> cls) {

        start(cls, null);
    }
}
