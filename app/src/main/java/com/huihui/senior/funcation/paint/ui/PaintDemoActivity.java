package com.huihui.senior.funcation.paint.ui;

import com.huihui.senior.R;
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
        TaiWanMapLayout taiwanMap = new TaiWanMapLayout(getApplicationContext());
        taiwanMap.bindData(R.raw.taiwan);
        list.add(new ItemBean("湾湾省地图", taiwanMap));

        TaiWanMapLayout chinaMap = new TaiWanMapLayout(getApplicationContext());
        chinaMap.bindData(R.raw.china);
        list.add(new ItemBean("中国地图", chinaMap));


        TaiWanMapLayout worldMap = new TaiWanMapLayout(getApplicationContext());
        worldMap.bindData(R.raw.world);
        list.add(new ItemBean("世界地图", worldMap));

        return list;
    }
}
