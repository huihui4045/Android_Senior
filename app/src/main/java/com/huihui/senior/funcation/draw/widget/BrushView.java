package com.huihui.senior.funcation.draw.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by gavin
 * Time 2017/5/19  10:16
 * Email:molu_clown@163.com
 */

public class BrushView extends View {

    private Paint paint;

    private Path path;


    public BrushView(Context context) {
        super(context);
        initView(context);
    }

    public BrushView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BrushView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        paint = new Paint();

        this.paint.setAntiAlias(true);
        this.paint.setColor(Color.BLUE);
        this.paint.setAlpha(100);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.ROUND);//设置线冒
        this.paint.setStrokeJoin(Paint.Join.ROUND);//设置线段连接处样式
        this.paint.setStrokeWidth(200);

        path = new Path();


    }

    @Override
    protected void onDraw(Canvas canvas) {


        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {


            case MotionEvent.ACTION_DOWN:

                path.reset();

                path.moveTo(event.getX(), event.getY());

                break;

            case MotionEvent.ACTION_MOVE:

                path.lineTo(event.getX(), event.getY());

                break;

            case MotionEvent.ACTION_UP:

                break;


        }

        postInvalidate();


        return true;
    }
}
