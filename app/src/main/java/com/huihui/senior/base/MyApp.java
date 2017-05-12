package com.huihui.senior.base;

import android.app.Application;
import android.view.View;

/**
 * Created by molu_ on 2017/5/12.
 */

public class MyApp extends Application {


   private View mView;

    public View getmView() {
        return mView;
    }

    public void setmView(View mView) {
        this.mView = mView;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
