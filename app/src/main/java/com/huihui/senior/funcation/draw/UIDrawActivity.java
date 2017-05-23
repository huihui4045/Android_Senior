package com.huihui.senior.funcation.draw;

import com.huihui.senior.base.DemoActivity;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.draw.widget.BrushView;
import com.huihui.senior.funcation.draw.widget.QuadBrushView;

import java.util.ArrayList;
import java.util.List;

public class UIDrawActivity extends DemoActivity {


    @Override
    public List<ItemBean> getDatas() {
        List<ItemBean> list = new ArrayList<>();

        list.add(new ItemBean("一般曲线", new BrushView(getApplicationContext())));
        list.add(new ItemBean("使用贝塞尔曲线", new QuadBrushView(getApplicationContext())));


        return list;
    }
}
