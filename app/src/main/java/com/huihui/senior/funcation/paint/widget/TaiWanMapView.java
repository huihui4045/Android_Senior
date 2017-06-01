package com.huihui.senior.funcation.paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.huihui.senior.funcation.paint.model.MapItem;
import com.huihui.senior.funcation.paint.util.AnalyzeSAX;

import java.io.InputStream;
import java.util.List;

/**
 * Created by gavin
 * Time 2017/6/1  9:57
 * Email:molu_clown@163.com
 * 台湾省地图
 */

public class TaiWanMapView extends View implements Handler.Callback {

    private List<MapItem> mapItems;

    private String TAG = this.getClass().getSimpleName();

    private Paint mPaint;

    private GestureDetectorCompat mCompat;

    private int mX;

    private int mY;

    private float mScale = 1.3f;

    public TaiWanMapView(Context context) {
        super(context);
        initView(context);
    }

    public TaiWanMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TaiWanMapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private Handler handler = new Handler(this);

    private void initView(Context context) {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        //setLayerType(LAYER_TYPE_SOFTWARE, mPaint);

        mCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {


            @Override
            public boolean onDown(MotionEvent e) {
                mX = (int) (e.getX() / mScale);

                mY = (int) (e.getY() / mScale);

                Log.e(TAG, " onSingleTapUp 点击了");

                postInvalidate();

                return super.onDown(e);
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {


                return super.onSingleTapConfirmed(e);
            }
        });


    }

    private OnItemMapClickListener listener;

    public void bindData(@RawRes final int rawTd, OnItemMapClickListener listener) {

        this.listener = listener;

        new Thread(new Runnable() {
            @Override
            public void run() {

                InputStream inputStream = getResources().openRawResource(rawTd);

                if (inputStream != null) {

                    /****
                     * AnalyzeSAX解析
                     */
                    mapItems = AnalyzeSAX.readXML(inputStream);
                    handler.sendEmptyMessage(200);
                }


            }
        }).start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.scale(mScale, mScale);

        if (mapItems != null && mapItems.size() > 0) {

            for (MapItem mapItem : mapItems) {


                boolean click = mapItem.isClick(mX, mY);

                if (click) {

                    listener.onItemMapClick(mapItem);
                }

                mapItem.drawMap(canvas, mPaint, click);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Log.e(TAG, "onTouchEvent");

        return this.mCompat.onTouchEvent(event);

    }

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.what == 200) {

            postInvalidate();
        }

        return true;
    }


    public interface OnItemMapClickListener {

        void onItemMapClick(MapItem item);
    }
}
