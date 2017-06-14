package com.huihui.senior.funcation.animator.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.huihui.senior.R;

/**
 * Created by molu_ on 2017/6/13.
 */

public class AnimatorLayout extends FrameLayout implements View.OnClickListener {
    private ImageView mImageDuo;

    public AnimatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public AnimatorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AnimatorLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        View.inflate(context, R.layout.item_animator_demo, this);

        mImageDuo = ((ImageView) findViewById(R.id.image_duo));
        mImageDuo.setOnClickListener(this);
    }

    private void startAnimation() {

        //mImageDuo.setTranslationX();
       // mImageDuo.setBackgroundColor();
       // ObjectAnimator animator=ObjectAnimator.ofFloat(mImageDuo,"translationX",0f,300f);

        ObjectAnimator animator=ObjectAnimator.ofInt(mImageDuo,"backgroundColor", Color.RED,Color.GREEN);

        animator.setDuration(1000);

        animator.start();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.image_duo:

                startAnimation();

                break;
        }
    }
}
