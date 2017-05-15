package com.huihui.senior.funcation.paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.view.View;

/**
 * Created by molu_ on 2017/5/15.
 * 滤镜效果
 */

public class FilterView extends View {

    public FilterView(Context context) {
        super(context);

        initView();
    }

    private void  initView(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ColorMatrix colorMatrix=new ColorMatrix(new float[]{



        });
    }
}
