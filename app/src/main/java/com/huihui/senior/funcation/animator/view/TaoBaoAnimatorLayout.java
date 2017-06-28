package com.huihui.senior.funcation.animator.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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

public class TaoBaoAnimatorLayout extends FrameLayout implements View.OnClickListener {
    private View mFirstView;
    private View mSecondView;

    public TaoBaoAnimatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public TaoBaoAnimatorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaoBaoAnimatorLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View.inflate(context, R.layout.item_tao_animator, this);

        mFirstView = findViewById(R.id.first);
        mSecondView = findViewById(R.id.second);


        mSecondView.setOnClickListener(this);

        findViewById(R.id.bt).setOnClickListener(this);
    }

    private void startFirstAnim(){

        ObjectAnimator FirstAlphaAnim=ObjectAnimator.ofFloat(mFirstView,"alpha",1.0f,0.7f);

        FirstAlphaAnim.setDuration(300);
        //mFirstView.setRotationX();

        ObjectAnimator firstRotationXAnim=ObjectAnimator.ofFloat(mFirstView,"rotationX",0f,20f);
        firstRotationXAnim.setDuration(300);


        ObjectAnimator firstResumeRotationXAnim=ObjectAnimator.ofFloat(mFirstView,"rotationX",20f,0f);

        firstResumeRotationXAnim.setDuration(300);

        firstResumeRotationXAnim.setStartDelay(300);


       // mFirstView.setScaleY();
        ObjectAnimator firstScaleYAnim=ObjectAnimator.ofFloat(mFirstView,"scaleY",1.0f,0.8f);
        firstScaleYAnim.setDuration(300);
        ObjectAnimator firstScaleXAnim=ObjectAnimator.ofFloat(mFirstView,"scaleX",1.0f,0.8f);

        firstScaleXAnim.setDuration(300);


        //mFirstView.setTranslationY();

        ObjectAnimator firstTranslationAnim=ObjectAnimator.ofFloat(mFirstView,"translationY",-0.1f*mFirstView.getHeight());
        firstTranslationAnim.setDuration(300);




        ObjectAnimator secondTranslationAnim=ObjectAnimator.ofFloat(mSecondView,"translationY",mSecondView.getHeight(),0);

        secondTranslationAnim.setDuration(300);

        secondTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mSecondView.setVisibility(VISIBLE);
            }
        });

        AnimatorSet animatorSet=new AnimatorSet();

        animatorSet.playTogether(firstTranslationAnim,FirstAlphaAnim,firstRotationXAnim,firstResumeRotationXAnim,firstScaleXAnim,firstScaleYAnim,secondTranslationAnim);

        animatorSet.start();



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt:

                startFirstAnim();

                break;
            case R.id.second:

                break;
        }
    }


}
