package com.huihui.senior.funcation.draw;

import com.huihui.senior.base.DemoActivity;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.paint.widget.MyDashView;

import java.util.ArrayList;
import java.util.List;

public class UIDrawActivity extends DemoActivity {


    @Override
    public List<ItemBean> getDatas() {

        List<ItemBean> list = new ArrayList<>();

        list.add(new ItemBean("间隔线", new MyDashView(getApplicationContext())));


        return list;
    }
}
