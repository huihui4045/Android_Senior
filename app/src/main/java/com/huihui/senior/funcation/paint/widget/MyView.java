package com.huihui.senior.funcation.paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by molu_ on 2017/5/11.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);


    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /****
         * 设置笔帽
         */
        // drawStrokeCap(canvas);

        /****
         * 设置连接处样式
         */
        // drawStrokeJoin(canvas);

        drawCornerPathEffectDemo(canvas);

    }

    private Path getPath() {
        Path path = new Path();
        // 定义路径的起点
        path.moveTo(0, 0);

        // 定义路径的各个点
        for (int i = 0; i <= 40; i++) {
            path.lineTo(i * 35, (float) (Math.random() * 150));
        }
        return path;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }


    /**
     * \圆形拐角效果
     * CornerPathEffect
     *
     * @param canvas
     */
    private void drawCornerPathEffectDemo(Canvas canvas) {
        Paint paint = getPaint();
        Path path = getPath();

        /*****
         * save()：用来保存Canvas的状态,save()方法之后的代码，能够调用Canvas的平移、放缩、旋转、裁剪等操作！
         */
        canvas.save();

        canvas.translate(100, 0);

        canvas.drawPath(path, paint);

        /*****
         * restore()：用来恢复Canvas之前保存的状态,防止save()方法代码之后对Canvas运行的操作。继续对兴许的绘制会产生影响。通过该方法能够避免连带的影响！
         */
        canvas.restore();
     /*
          圆形拐角效果*/

        paint.setPathEffect(new CornerPathEffect(200));


        canvas.translate(0, 150);
        canvas.drawPath(path, paint);
    }


    private void drawStrokeJoin(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(60);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(450, 100);
        path.lineTo(100, 300);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, paint);

        path.moveTo(100, 400);
        path.lineTo(450, 400);
        path.lineTo(100, 600);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, paint);

        path.moveTo(100, 700);
        path.lineTo(450, 700);
        path.lineTo(100, 900);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);
    }

    private void drawStrokeCap(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(80);
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        //paint.setStrokeMiter(); //画笔的倾斜度
        //paint.setDither();//设置图像是否使用抖动处理,会使得绘制出来的图片更加平滑和饱满，图像更加清晰

        paint.setStrokeCap(Paint.Cap.BUTT);// 无线帽
        canvas.drawLine(100, 200, 400, 200, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100, 400, 400, 400, paint);// 方形线帽

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 600, 400, 600, paint);// 圆形线帽

    }
}
