package com.huihui.senior.funcation.paint.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.huihui.senior.R;
import com.huihui.senior.funcation.paint.widget.CircleProgressBar;

/**
 * Created by molu_ on 2017/5/22.
 */

public class CircleProgressLayout extends FrameLayout implements Handler.Callback {
    private CircleProgressBar mCircleProgressBar;

    private Handler mHandler = new Handler(this);

    public CircleProgressLayout(@NonNull Context context) {
        this(context, null);
    }

    public CircleProgressLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CircleProgressLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(context, R.layout.item_circle_progress, this);

        mCircleProgressBar = ((CircleProgressBar) view.findViewById(R.id.bar));

        mCircleProgressBar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mHandler.sendEmptyMessageDelayed(200, 200);
            }
        });


    }

    private int progress = 0;

    @Override
    public boolean handleMessage(Message msg) {


        if (msg.what == 200) {

            mCircleProgressBar.setProgress(progress);

            progress++;

            if (progress <=100) {

                mHandler.sendEmptyMessageDelayed(200, 200);
            } else {

                mHandler.removeCallbacksAndMessages(null);
            }


        }


        return false;
    }
}
