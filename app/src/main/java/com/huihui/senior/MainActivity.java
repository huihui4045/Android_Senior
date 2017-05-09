package com.huihui.senior;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.ui.UIDrawActivity;

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

        return data;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ItemBean item = (ItemBean) parent.getAdapter().getItem(position);

        start(item.getaClass(), item.getName());
    }


    private class MyAdapter extends BaseAdapter {

        private Context context;


        private List<ItemBean> items;

        public MyAdapter(Context context, List<ItemBean> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items == null ? 0 : items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder = null;

            if (convertView == null) {

                convertView = LayoutInflater.from(context).inflate(R.layout.item_simple, null);

                viewHolder = new ViewHolder();

                viewHolder.textView = (TextView) convertView.findViewById(R.id.tvName);

                convertView.setTag(viewHolder);
            } else {

                viewHolder = (ViewHolder) convertView.getTag();

            }


            ItemBean itemBean = items.get(position);

            viewHolder.textView.setText(itemBean.getName());


            return convertView;
        }
    }


    static class ViewHolder {

        public TextView textView;
    }
}
