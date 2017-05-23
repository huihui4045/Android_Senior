package com.huihui.senior.funcation.draw;

import android.os.Bundle;

import com.huihui.senior.base.BaseActivity;
import com.huihui.senior.R;

public class UIDrawActivity extends BaseActivity {

    @Override
    public List<ItemBean> getDatas() {
        List<ItemBean> list = new ArrayList<>();

        list.add(new ItemBean("一般曲线", new BrushView(getApplicationContext())));
        list.add(new ItemBean("使用贝塞尔曲线", new QuadBrushView(getApplicationContext())));



        list.add(new ItemBean("间隔线", new MyDashView(getApplicationContext())));
        list.add(new ItemBean("流式布局", new WaterfallView(getApplicationContext())));


        return list;
    }
}
