package com.huihui.senior.funcation.paint.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by gavin
 * Time 2017/5/11  15:23
 * Email:molu_clown@163.com
 */

public class MyDashView extends View {

    private int dashDx=0;


    public MyDashView(Context context) {
        super(context);
    }

    public MyDashView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDashPathEffect(canvas);
    }

    private Paint getPaint(){
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private void drawDashPathEffect(Canvas canvas){
        Paint paint = getPaint();
        Path path = new Path();
        path.moveTo(100,600);
        path.lineTo(400,100);
        path.lineTo(700,900);

        canvas.drawPath(path,paint);
        paint.setColor(Color.RED);

        //使用DashPathEffect画线段
        paint.setPathEffect(new DashPathEffect(new float[]{20,10,},0));
        canvas.translate(0,200);
        canvas.drawPath(path,paint);


        //画同一条线段,偏移值为15
        paint.setPathEffect(new DashPathEffect(new float[]{100,100},dashDx));
        paint.setColor(Color.RED);
        canvas.translate(0,200);
        canvas.drawPath(path,paint);
    }

    public void startAnim(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,20);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dashDx = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

}
