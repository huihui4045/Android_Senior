package com.huihui.senior.funcation.paint.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.huihui.senior.funcation.paint.widget.TaiWanMapView;

/**
 * Created by gavin
 * Time 2017/6/1  9:52
 * Email:molu_clown@163.com
 * 台湾地图 容器
 */

public class TaiWanMapLayout extends FrameLayout {

    public TaiWanMapLayout(@NonNull Context context) {
        this(context, null);
    }

    public TaiWanMapLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaiWanMapLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        FrameLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


        TaiWanMapView view = new TaiWanMapView(context);

        addView(view, params);

    }
}
