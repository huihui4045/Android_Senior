package com.huihui.senior.bean;

/**
 * Created by molu_ on 2017/5/9.
 */

public class ItemBean {

    private String name;

    private Class aClass;

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
}
