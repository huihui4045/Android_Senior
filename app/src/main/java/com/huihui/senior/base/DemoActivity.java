package com.huihui.senior.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.huihui.senior.bean.ItemBean;

import java.util.List;

public abstract class DemoActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(getApplicationContext());


        listView.setAdapter(new MyAdapter(getApplicationContext(), getDatas()));


        listView.setOnItemClickListener(this);


        setContentView(listView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    public abstract List<ItemBean> getDatas();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ItemBean itemBean = (ItemBean) parent.getAdapter().getItem(position);

        String name = itemBean.getName();
        View child = itemBean.getView();

        ((MyApp) getApplication()).setmView(child);

        start(ShowActivity.class, name);

    }
}
