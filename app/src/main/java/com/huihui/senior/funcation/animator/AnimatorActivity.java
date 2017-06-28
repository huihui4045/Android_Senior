package com.huihui.senior.funcation.animator;

import com.huihui.senior.base.DemoActivity;
import com.huihui.senior.bean.ItemBean;
import com.huihui.senior.funcation.animator.view.AnimatorLayout;
import com.huihui.senior.funcation.animator.view.TaoBaoAnimatorLayout;

import java.util.ArrayList;
import java.util.List;

public class AnimatorActivity extends DemoActivity {



    @Override
    public List<ItemBean> getDatas() {
        List<ItemBean> list = new ArrayList<>();
        list.add(new ItemBean("属性动画demo", new AnimatorLayout(getApplicationContext())));
        list.add(new ItemBean("淘宝属性动画demo", new TaoBaoAnimatorLayout(getApplicationContext())));

        return list;
    }
}
