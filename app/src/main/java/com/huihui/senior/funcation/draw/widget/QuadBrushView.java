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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin
 * Time 2017/5/19  10:16
 * Email:molu_clown@163.com
 */

public class QuadBrushView extends View {

    private Paint paint;

    private Path path;

    private List<Point> mPoints = new ArrayList<>();


    public QuadBrushView(Context context) {
        super(context);
        initView(context);
    }

    public QuadBrushView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public QuadBrushView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {


            case MotionEvent.ACTION_DOWN:

                path.reset();

                path.moveTo(x, y);

                Point point = new Point(x, y);
                mPoints.add(point);


                break;

            case MotionEvent.ACTION_MOVE:


                float f3 = ((Point) this.mPoints.get(-1 + this.mPoints.size())).x;
                float f4 = ((Point) this.mPoints.get(-1 + this.mPoints.size())).y;
                float f5 = Math.abs(x - f3);
                float f6 = Math.abs(y - f4);


                if ((f5 >= 3.0F) || (f6 >= 3.0F)) {
                    float f7 = (x + f3) / 2.0F;
                    float f8 = (y + f4) / 2.0F;
                    this.path.quadTo(f3, f4, f7, f8);
                    Point point1 = new Point(x, y);
                    mPoints.add(point1);
                }


                break;

            case MotionEvent.ACTION_UP:

                break;


        }



        postInvalidate();


        return true;
    }

    private class Point {

        float x;

        float y;


        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
