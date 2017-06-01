package com.huihui.senior.funcation.paint.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.huihui.senior.R;

/**
 * Created by molu_ on 2017/5/22.
 * 自定义进度条
 */

public class CircleProgressBar extends View {

    private int max;
    private int roundColor;
    private int roundProgressColor;
    private int textColor;
    private float textSize;
    private float roundWidth;
    private boolean textShow;
    private int progress;
    private Paint paint;
    public static final int STROKE = 0;
    public static final int FILL = 1;

    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 200;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {

        paint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        max = typedArray.getInteger(R.styleable.CustomProgressBar_max, 100);
        roundColor = typedArray.getColor(R.styleable.CustomProgressBar_roundColor, Color.RED);
        roundProgressColor = typedArray.getColor(R.styleable.CustomProgressBar_roundProgressColor, Color.BLUE);
        textColor = typedArray.getColor(R.styleable.CustomProgressBar_textColor, Color.GREEN);
        textSize = typedArray.getDimension(R.styleable.CustomProgressBar_textSize, 55);
        roundWidth = typedArray.getDimension(R.styleable.CustomProgressBar_roundWidth, 30);
        textShow = typedArray.getBoolean(R.styleable.CustomProgressBar_textShow, true);


        typedArray.recycle();
    }

    private int center_x;
    private int center_y;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int paddingLeft = getPaddingLeft();

        int paddingRight = getPaddingRight();

        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        /*****
         * 绘制圆环
         */

        int width = getWidth() - paddingLeft - paddingRight;

        int height = getHeight() - paddingBottom - paddingTop;

        paint.setColor(roundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth); // 圆环的宽度
        paint.setAntiAlias(true);

        float radius = Math.min(width, height) / 2 - roundWidth / 2;

        center_y = paddingTop + height / 2;
        center_x = paddingLeft + width / 2;
        canvas.drawCircle(center_x, center_y, radius, paint);

        // 画进度百分比
        paint.setColor(textColor);
        paint.setStrokeWidth(0);
        paint.setTextSize(textSize);
        paint.setTypeface(Typeface.DEFAULT_BOLD);

        int percent = progress * 100 / max;

        String strPercent = percent + "%";
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();


        canvas.drawText(strPercent, center_x - paint.measureText(strPercent) / 2, center_y + (fm.bottom - fm.top) / 2 - fm.bottom, paint);


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(roundWidth);

        RectF rectF = new RectF(center_x - radius, center_y - radius, center_x + radius, center_y + radius);

        canvas.drawArc(rectF, 0, 360 * percent / max, false, paint);

    }

    public void setProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("进度Progress不能小于0");
        }
        if (progress > max) {

            this.progress = max;
        }

        if (progress <= max) {

            this.progress = progress;

            postInvalidate();

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpceMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpcesize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpceMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpcesize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpceMode == MeasureSpec.AT_MOST && widthSpceMode == MeasureSpec.AT_MOST) {

            setMeasuredDimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        } else if (widthSpceMode == MeasureSpec.AT_MOST) {

            setMeasuredDimension(DEFAULT_WIDTH, heightSpcesize);
        } else if (heightSpceMode == MeasureSpec.AT_MOST) {

            setMeasuredDimension(widthSpcesize, DEFAULT_HEIGHT);
        }
    }
}
