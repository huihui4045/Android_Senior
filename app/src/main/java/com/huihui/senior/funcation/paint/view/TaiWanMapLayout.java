package com.huihui.senior.funcation.paint.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huihui.senior.funcation.paint.model.MapItem;
import com.huihui.senior.funcation.paint.widget.TaiWanMapView;

/**
 * Created by gavin
 * Time 2017/6/1  9:52
 * Email:molu_clown@163.com
 * 台湾地图 容器
 */

public class TaiWanMapLayout extends RelativeLayout implements TaiWanMapView.OnItemMapClickListener {

    private  TaiWanMapView mapview;
    private TextView textView;
    private String TAG = this.getClass().getSimpleName();

    public TaiWanMapLayout(@NonNull Context context) {
        this(context, null);
    }

    public TaiWanMapLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaiWanMapLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setBackgroundColor(0xFFF0f0f0);

        RelativeLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


         mapview = new TaiWanMapView(context);



        addView(mapview, params);

        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        textParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        textView = new TextView(context);

        textView.setPadding(10, 20, 10, 20);

        textView.setBackgroundColor(0xa9CCCCCC);
        textView.setGravity(Gravity.CENTER);


        addView(textView, textParams);


    }

    public void bindData(@RawRes int rawId){

        mapview.bindData(rawId, this);
    }

    @Override
    public void onItemMapClick(MapItem item) {

        textView.setText(String.format("你先择的是 %s", item.getName()));
    }
}
