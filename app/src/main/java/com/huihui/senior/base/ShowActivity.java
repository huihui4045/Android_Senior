package com.huihui.senior.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.huihui.senior.R;

public class ShowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApp application = (MyApp) getApplication();

        View view = application.getmView();


        if (view != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            setContentView(view, params);

        } else {

            setContentView(R.layout.activity_show);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        View view = ((MyApp) getApplication()).getmView();
        ((ViewGroup) view.getParent()).removeView(view);

    }
}
