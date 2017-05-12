package com.huihui.senior.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huihui.senior.R;
import com.huihui.senior.bean.ItemBean;

import java.util.List;

/**
 * Created by molu_ on 2017/5/12.
 */

public class MyAdapter extends BaseAdapter {

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

    static class ViewHolder {

        public TextView textView;
    }
}
