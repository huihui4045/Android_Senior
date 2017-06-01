package com.huihui.senior.funcation.paint.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by gavin
 * Time 2017/6/1  10:03
 * Email:molu_clown@163.com
 */

public class MapItem {

    private Path path;

    private int fillColor;

    private int strokeColor;


    /****
     * 地图的人数
     */
    private int num;

    public MapItem() {
    }


    public void setPath(Path path) {
        this.path = path;
    }


    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }


    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    /*****
     * 绘制地图
     * @param canvas
     */
    public void drawMap(Canvas canvas, Paint paint, boolean isFocused) {

        canvas.save();


        paint.setStrokeWidth(1);
        paint.setColor(fillColor);
        paint.setStyle(Paint.Style.FILL);

        if (isFocused) {


        } else {


        }


        canvas.drawPath(path, paint);


    }

    /****
     * 是否点击
     * @return
     */
    public boolean isClick(int x, int y) {

        return false;
    }
}
