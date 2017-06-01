package com.huihui.senior.funcation.paint.util;

import android.graphics.Color;

import com.huihui.senior.funcation.paint.PathParser;
import com.huihui.senior.funcation.paint.model.MapItem;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin
 * Time 2017/6/1  10:22
 * Email:molu_clown@163.com
 */

public class XMLContentHandler extends DefaultHandler {

    private List<MapItem> mapItems;

    private String tagName = null;

    private MapItem currentMapItem = null;

    public List<MapItem> getMapItems() {
        return mapItems;
    }

    /*****
     * 当遇到文档的开头的时候，调用这个方法，可以在其中做一些预处理的工作
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        mapItems = new ArrayList<>();
    }

    /*****
     * 来处理在XML文件中读到的内容
     * @param ch   文件的字符串内容
     * @param start   数组中的起始位置和长度
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }

    /******
     *
     * @param uri  命名空间
     * @param localName  不带命名空间前缀的标签名
     * @param qName       带命名空间前缀的标签名
     * @param attributes  通过atts可以得到所有的属性名和相应的值
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("path")) {

            currentMapItem = new MapItem();

            currentMapItem.setPath(PathParser.createPathFromPathData(attributes.getValue("pathData")));

            String id = attributes.getValue("id");
            if (id!=null){

                currentMapItem.setId(Integer.parseInt(id));
            }
            String name = attributes.getValue("name");
            if (name!=null){

                currentMapItem.setName(name);
            }

            currentMapItem.setNum(getNum());

            int argb = Color.argb(currentMapItem.getNum(), currentMapItem.getNum(), 0, currentMapItem.getNum());

            currentMapItem.setFillColor(argb);
            currentMapItem.setStrokeColor(0xFFCCCCCC);

        }

        this.tagName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("path")) {

            mapItems.add(currentMapItem);

            currentMapItem = null;
        }

        this.tagName = null;
    }


    /*****
     * 获取num
     * @return
     */
    private int getNum() {

        int v = (int) (Math.random() * nums.length);

        return nums[v];
    }

    private int[] nums = new int[]{10, 20, 40,50,80,110,130, 245, 56, 255, 45, 110, 150, 170, 190, 220, 70};
}
