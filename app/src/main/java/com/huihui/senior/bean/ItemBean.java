package com.huihui.senior.bean;

import android.view.View;

/**
 * Created by molu_ on 2017/5/9.
 */

public class ItemBean {

    private String name;

    private Class aClass;

    private View view;

    public ItemBean(String name, View view) {
        this.name = name;
        this.view = view;
    }

    public ItemBean(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    public Class getaClass() {
        return aClass;
    }

    public View getView() {
        return view;
    }
}
