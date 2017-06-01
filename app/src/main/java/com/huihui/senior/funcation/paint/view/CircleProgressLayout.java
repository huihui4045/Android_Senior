package com.huihui.senior.funcation.paint.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.huihui.senior.R;

/**
 * Created by molu_ on 2017/5/22.
 */

public class CircleProgressLayout extends FrameLayout {
    public CircleProgressLayout(@NonNull Context context) {
        this(context,null);
    }

    public CircleProgressLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public CircleProgressLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(context, R.layout.item_circle_progress, this);



    }
}
