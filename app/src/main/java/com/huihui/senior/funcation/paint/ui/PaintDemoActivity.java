package com.huihui.senior.funcation.paint.ui;

import android.os.Bundle;

import com.huihui.senior.BaseActivity;
import com.huihui.senior.R;
import com.huihui.senior.funcation.paint.widget.MyDashView;

/****
 * 画笔
 */
public class PaintDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_demo);

        ((MyDashView) findViewById(R.id.myDashView)).startAnim();


    }
}
