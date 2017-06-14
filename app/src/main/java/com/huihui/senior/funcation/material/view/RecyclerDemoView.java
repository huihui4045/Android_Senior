package com.huihui.senior.funcation.material.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.huihui.senior.funcation.material.adapter.ArticleWithHeaderAdapter;
import com.huihui.senior.funcation.material.bean.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin
 * Time 2017/6/13  11:20
 * Email:molu_clown@163.com
 */

public class RecyclerDemoView extends FrameLayout {

    public RecyclerDemoView(@NonNull Context context) {
        this(context, null);
    }

    public RecyclerDemoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public RecyclerDemoView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        RecyclerView recyclerView = new RecyclerView(context);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(recyclerView, params);


        List<Article> list = new ArrayList<>();

        for (int i = 0; i < 200; i++) {

            list.add(new Article("标题" + i, "时间" + i, "作者" + i));
        }

        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        ArticleWithHeaderAdapter adapter = new ArticleWithHeaderAdapter(list);

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);



    }
}
