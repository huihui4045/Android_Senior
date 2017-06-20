package com.huihui.senior.funcation.material;

import com.huihui.senior.base.DemoActivity;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.material.view.RecyclerDemoView;

import java.util.ArrayList;
import java.util.List;

public class MaterialActivity extends DemoActivity {



    @Override
    public List<ItemBean> getDatas() {

        List<ItemBean> list = new ArrayList<>();

        list.add(new ItemBean("RecyclerViewDemo", new RecyclerDemoView(getApplicationContext())));
        return list;
    }
}
