package com.huihui.senior.base;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huihui.senior.R;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.draw.UIDrawActivity;
import com.huihui.senior.funcation.paint.ui.PaintDemoActivity;
import com.huihui.senior.funcation.path.PathDemoActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Android UI高级");

        mListView = ((ListView) findViewById(R.id.listView));


        mListView.setAdapter(new MyAdapter(getApplicationContext(), getData()));
        mListView.setOnItemClickListener(this);


    }


    private List<ItemBean> getData() {

        List<ItemBean> data = new ArrayList<>();

        data.add(new ItemBean("UI绘制流程", UIDrawActivity.class));
        data.add(new ItemBean("Paint使用demo", PaintDemoActivity.class));
        data.add(new ItemBean("Path使用demo", PathDemoActivity.class));

        return data;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ItemBean item = (ItemBean) parent.getAdapter().getItem(position);

        start(item.getaClass(), item.getName());
    }


}
