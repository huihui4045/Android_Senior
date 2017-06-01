package com.huihui.senior.funcation.paint.util;

import com.huihui.senior.funcation.paint.model.MapItem;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by gavin
 * Time 2017/6/1  11:21
 * Email:molu_clown@163.com
 * SAX 解析器
 */

public class AnalyzeSAX {

    public static List<MapItem> readXML(InputStream inputStream) {

        //SAX解析的工厂对象
        SAXParserFactory factory = SAXParserFactory.newInstance();

        //得到sax的解析器
        try {

            SAXParser saxParser = factory.newSAXParser();

            //创建handler对象
            XMLContentHandler handlerService = new XMLContentHandler();

            saxParser.parse(inputStream, handlerService);

            inputStream.close();

            return handlerService.getMapItems();

        } catch (ParserConfigurationException e) {

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
