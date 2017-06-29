package com.huihui.senior;

import com.huihui.senior.base.DemoActivity;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.test.async.AsyncLayout;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends DemoActivity {


    @Override
    public List<ItemBean> getDatas() {
        List<ItemBean> list = new ArrayList<>();

        list.add(new ItemBean("AsyncTaskDemo", new AsyncLayout(getApplicationContext())));



        return list;
    }
}
