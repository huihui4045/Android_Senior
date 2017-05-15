package com.huihui.senior.funcation.paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
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

        // drawCornerPathEffectDemo(canvas);
        /*****
         * 设置圆形拐角效果
         */
       // drawCornerPathEffect(canvas);

        /*****
         * 打散Path的线段，使得在原来路径的基础上发生打散效果。
         */
        //drawDiscretePathEffectDemo(canvas);

        drawPathDashPathEffectDemo(canvas);

    }

    /****
     * 这个类的作用是使用Path图形来填充当前的路径，
     * 其构造函数为PathDashPathEffect (Path shape, float advance, float phase,PathDashPathEffect.Stylestyle)。
     * shape则是指填充图形，advance指每个图形间的间距，phase为绘制时的偏移量，
     * style为该类自由的枚举值，有三种情况：Style.ROTATE、Style.MORPH和
      Style.TRANSLATE。
       其中ROTATE的情况下，线段连接处的图形转换以旋转到与下一段移动方向相一致的角度进行转转，
        MORPH时图形会以发生拉伸或压缩等变形的情况与下一段相连接，
        TRANSLATE时，图形会以位置平移的方式与下一段相连接。
     * @param canvas
     */
    private void drawPathDashPathEffectDemo(Canvas canvas){
        Paint paint = getPaint();

        Path path = getPath();
        canvas.drawPath(path,paint);

        canvas.translate(0,200);

        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,0, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path,paint);

        canvas.translate(0,200);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,0, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path,paint);

        canvas.translate(0,200);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawPath(path,paint);
    }


    private Path getStampPath(){
        Path path  = new Path();
        path.moveTo(0,20);
        path.lineTo(10,0);
        path.lineTo(20,20);
        path.close();

        path.addCircle(0,0,3, Path.Direction.CCW);

        return path;
    }

    /***
     * 打散Path的线段，使得在原来路径的基础上发生打散效果。
     * @param canvas
     */
    private void drawDiscretePathEffectDemo(Canvas canvas){
        Paint paint = getPaint();
        Path path = getPath();

        canvas.drawPath(path,paint);
        /**
         * 把原有的路线,在指定的间距处插入一个突刺
         * 第一个这些突出的“杂点”的间距,值越小间距越短,越密集
         * 第二个是突出距离
         * segmentLength指定最大的段长，
         * deviation指定偏离量。
         */
        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(2,5));
        canvas.drawPath(path,paint);

        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(6,5));
        canvas.drawPath(path,paint);


        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(6,15));
        canvas.drawPath(path,paint);
    }

    /*****
     * 圆形拐角效果
     * CornerPathEffect：
     这个类的作用就是将Path的各个连接线段之间的夹角用一种更平滑的方式连接，类似于圆弧与切线的效果。
     一般的，通过CornerPathEffect(float radius)指定一个具体的圆弧半径来实例化一个CornerPathEffect。
     * @param canvas
     */
    private void drawCornerPathEffect(Canvas canvas) {
        Paint paint = getPaint();
        Path path = new Path();
        path.moveTo(100, 600);
        path.lineTo(400, 100);
        path.lineTo(700, 900);

        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);
        /*****
         * 半径 内切圆
         */
        paint.setPathEffect(new CornerPathEffect(100));
        canvas.drawPath(path, paint);

        paint.setPathEffect(new CornerPathEffect(200));
        paint.setColor(Color.GREEN);
        canvas.drawPath(path, paint);
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
