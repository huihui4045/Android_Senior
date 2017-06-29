package com.huihui.senior.funcation.test.async;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by gavin
 * Time 2017/6/29  11:32
 * Email:molu_clown@163.com
 */

public class AsyncLayout extends FrameLayout {
    public AsyncLayout(@NonNull Context context) {
        this(context,null);
    }

    public AsyncLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AsyncLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
