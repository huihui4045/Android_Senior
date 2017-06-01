package com.huihui.senior.funcation.paint.ui;

import com.huihui.senior.base.DemoActivity;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.paint.view.CircleProgressLayout;
import com.huihui.senior.funcation.paint.view.TaiWanMapLayout;
import com.huihui.senior.funcation.paint.widget.FilterView;
import com.huihui.senior.funcation.paint.widget.MyDashView;
import com.huihui.senior.funcation.paint.widget.MyView;

import java.util.ArrayList;
import java.util.List;

/****
 * 画笔的用法
 */
public class PaintDemoActivity extends DemoActivity {


    @Override
    public List<ItemBean> getDatas() {

        List<ItemBean> list = new ArrayList<>();

        list.add(new ItemBean("间隔线", new MyDashView(getApplicationContext())));
        list.add(new ItemBean("Paint基本用法", new MyView(getApplicationContext())));
        list.add(new ItemBean("颜色矩阵", new FilterView(getApplicationContext())));
        list.add(new ItemBean("自定义进度条", new CircleProgressLayout(getApplicationContext())));
        list.add(new ItemBean("湾湾省地图",new TaiWanMapLayout(getApplicationContext())));

        return list;
    }
}
