package com.huihui.senior.funcation.draw.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.huihui.senior.R;
import com.huihui.senior.funcation.draw.widget.WaterfallLayout;

import java.util.Random;

/**
 * Created by molu_ on 2017/5/22.
 * <p>
 * 流式View
 */

public class WaterfallView extends FrameLayout {
    private static int IMG_COUNT = 5;

    private Context context;
    public WaterfallView(@NonNull Context context) {
        this(context, null);
    }

    public WaterfallView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public WaterfallView(@NonNull final Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;

        View.inflate(context, R.layout.item_waterfall_view, this);

        final WaterfallLayout waterfallLayout = ((WaterfallLayout)findViewById(R.id.waterfallLayout));
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addView(waterfallLayout,context);
            }
        });


    }

    public void addView(WaterfallLayout waterfallLayout, final Context context) {


        Random random = new Random();
        Integer num = Math.abs(random.nextInt());
        WaterfallLayout.LayoutParams layoutParams = new WaterfallLayout.LayoutParams(
                WaterfallLayout.LayoutParams.MATCH_PARENT,
                WaterfallLayout.LayoutParams.MATCH_PARENT);
        /*WaterfallLayout.LayoutParams layoutParams = new WaterfallLayout.LayoutParams(
                100,
                100);*/
        ImageView imageView = new ImageView(context);
        if (num % IMG_COUNT == 0) {
            imageView.setImageResource(R.drawable.pic_1);
        } else if (num % IMG_COUNT == 1) {
            imageView.setImageResource(R.drawable.pic_2);
        } else if (num % IMG_COUNT == 2) {
            imageView.setImageResource(R.drawable.pic_3);
        } else if (num % IMG_COUNT == 3) {
            imageView.setImageResource(R.drawable.pic_4);
        } else if (num % IMG_COUNT == 4) {
            imageView.setImageResource(R.drawable.pic_5);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        waterfallLayout.addView(imageView, layoutParams);

        waterfallLayout.setOnItemClickListener(
                new WaterfallLayout.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int index) {
                        Toast.makeText(context, "item=" + index, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
