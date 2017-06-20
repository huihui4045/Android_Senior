package com.huihui.senior.funcation.material.bean;

/**
 * Created by gavin
 * Time 2017/6/13  11:33
 * Email:molu_clown@163.com
 */

public class Article {

    private String title;

    private String publishTime;

    private String author;

    public Article(String title, String publishTime, String author) {
        this.title = title;
        this.publishTime = publishTime;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
