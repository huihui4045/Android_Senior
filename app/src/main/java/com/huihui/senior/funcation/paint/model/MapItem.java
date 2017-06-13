package com.huihui.senior.funcation.paint.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;


/**
 * Created by gavin
 * Time 2017/6/1  10:03
 * Email:molu_clown@163.com
 */

public class MapItem {

    private Path path;

    private int fillColor;

    private int strokeColor;

    private int id;

    private String name;




    /*****
     * 构造一个区域对象，左闭右开的。
     */
    RectF f = new RectF();

    Region region = new Region();


    /****
     * 地图的人数
     */
    private int num;

    public MapItem() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
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

        /****
         * 被点击
         */
        if (isFocused) {

            paint.setStrokeWidth(5);
            paint.setColor(fillColor);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setShadowLayer(10, 0, 0, 0xFFFFFFFF);

        } else {

            paint.setStrokeWidth(1);
            paint.setColor(fillColor);
            paint.setStyle(Paint.Style.FILL);
        }

        canvas.restore();

        canvas.drawPath(path, paint);


    }

    /****
     * 是否点击  判断一个点 是否在指定的区域内
     * @return
     */
    public boolean isClick(int x, int y) {


        /****()
         * 计算控制点的边界
         */
        path.computeBounds(f, false);

        region.setPath(path, new Region((int) f.left, (int) f.top, (int) f.right, (int) f.bottom));


        return region.contains(x, y);
    }
}
