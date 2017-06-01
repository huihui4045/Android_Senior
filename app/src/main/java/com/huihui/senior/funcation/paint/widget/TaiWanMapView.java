package com.huihui.senior.funcation.paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.huihui.senior.R;
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

    private Paint mPaint;

    public TaiWanMapView(Context context) {
        super(context);
        initView();
    }

    public TaiWanMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TaiWanMapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private Handler handler = new Handler(this);

    private void initView() {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);


        new Thread(new Runnable() {
            @Override
            public void run() {

                InputStream inputStream = getResources().openRawResource(R.raw.taiwan);

                /****
                 * AnalyzeSAX解析
                 */
                mapItems = AnalyzeSAX.readXML(inputStream);

                handler.sendEmptyMessage(200);
            }
        }).start();


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.scale(1.3f,1.3f);

        if (mapItems != null && mapItems.size() > 0) {

            for (MapItem mapItem : mapItems) {


                mapItem.drawMap(canvas, mPaint,true);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.what == 200) {

            postInvalidate();
        }

        return true;
    }
}
