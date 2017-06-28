package com.huihui.senior.funcation.animator.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
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

       /* ObjectAnimator animator=ObjectAnimator.ofInt(mImageDuo,"backgroundColor", Color.RED,Color.GREEN);

        animator.setDuration(1000);

        animator.start();*/

        //多个动画同时执行


       /* final ObjectAnimator animator=ObjectAnimator.ofFloat(mImageDuo,"alpha",0f,1f);

        *//*animator.setDuration(300);
        animator.setRepeatCount(2);
        animator.setRepeatMode(ValueAnimator.REVERSE);*//*

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedFraction = animation.getAnimatedFraction();//执行百分比

             float value= (float) animator.getAnimatedValue();

                mImageDuo.setScaleX(0.5f+value);
                mImageDuo.setScaleY(0.5f+value);

                mImageDuo.setTranslationX(value*100);



            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });

        animator.start();*/


       /* ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,200f);
        valueAnimator.setDuration(500);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value= (float) animation.getAnimatedValue();
                mImageDuo.setScaleX(0.5f+value);
                mImageDuo.setScaleY(0.5f+value);

                mImageDuo.setTranslationX(value*100);
            }
        });*/


        //方法三

        /*PropertyValuesHolder holder1=PropertyValuesHolder.ofFloat("alpha",1f,0.5f);
        PropertyValuesHolder holder2=PropertyValuesHolder.ofFloat("scaleX",1f,0.5f);
        PropertyValuesHolder holder3=PropertyValuesHolder.ofFloat("scaleY",1f,0.5f);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mImageDuo, holder1, holder2, holder3);

        animator.setDuration(300);
        animator.start();*/

        //方法四

        /*ObjectAnimator animator1=ObjectAnimator.ofFloat(mImageDuo,"translationX",0f,200f);
        ObjectAnimator animator2=ObjectAnimator.ofFloat(mImageDuo,"alpha",0f,1f);
        ObjectAnimator animator3=ObjectAnimator.ofFloat(mImageDuo,"scaleX",0f,2f);

        animator1.setStartDelay(1000);

        AnimatorSet animatorSet=new AnimatorSet();

        animatorSet.setDuration(1000);
        animatorSet.playTogether(animator1,animator2,animator3);
       // animatorSet.playSequentially(animator1,animator2,animator3);

        animatorSet.start();*/

        //.......................自由落体运动

       /* ValueAnimator animator = new ValueAnimator();

        animator.setDuration(4000);
        animator.setObjectValues(new PointF(0, 0));

        final PointF pointF = new PointF();

        animator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                //

                pointF.x = 100f * fraction * 10;

                pointF.y = 0.5f * 29f * (fraction * 10) * (fraction * 10);


                return pointF;
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {


                PointF pointF1 = (PointF) animation.getAnimatedValue();
                mImageDuo.setX(pointF1.x);
                mImageDuo.setY(pointF1.y);
            }
        });

        animator.start();*/


       //插值器

        ObjectAnimator animator=ObjectAnimator.ofFloat(mImageDuo,"translationY",0f,1000f);

        animator.setInterpolator(new AccelerateInterpolator(50));
        animator.setInterpolator(new BounceInterpolator());

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
