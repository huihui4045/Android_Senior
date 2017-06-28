package com.huihui.senior.funcation.animator.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.huihui.senior.R;

/**
 * Created by molu_ on 2017/6/27.
 */

public class TaoBaoAnimatorLayout extends FrameLayout {
    public TaoBaoAnimatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public TaoBaoAnimatorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaoBaoAnimatorLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View.inflate(context, R.layout.item_tao_animator, this);
    }
}
