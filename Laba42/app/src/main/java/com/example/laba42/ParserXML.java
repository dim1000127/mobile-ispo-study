package com.example.laba42;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class ParserXML {

    String xmlStr;
    List<TestValute> testvalute;
    String tagName, textCharCode, textName;
    double textValue;
    int textNumCode;

    public ParserXML(String _xmlStr, List<TestValute> _testvalute) {
        xmlStr = _xmlStr;
        testvalute = _testvalute;


        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    // начало тэга
                    case XmlPullParser.START_TAG:
                        // сохраняем xpp.getName() в tagName
                        tagName = xpp.getName();
                        break;

                    case XmlPullParser.END_TAG:
                        //для сравнения строк можно использовать следующую конструкцию
                        if (xpp.getName().equals("Valute")) {
                            testvalute.add(new TestValute(textNumCode, textCharCode, textName, textValue));
                        }
                        break;
                    // если xpp.getName() - «Valute», значит, закончился фрагмент xml
                    //с информацией об очередной валюте, создаем объект класса testValute,
                    //передаем ему в конструкторе параметры  textNumCode,  textCharCode,
                    // textName, textValute и добавляем этот объект в список

                    // содержимое тэга
                    case XmlPullParser.TEXT: {
                        //для сравнения строк можно использовать следующую конструкцию
                        //if( tagName.equals("Name") )
                        if (tagName.equals("NameCode")) {
                            textNumCode = Integer.valueOf(xpp.getText());
                        }

                        if (tagName.equals("CharCode")) {
                            textCharCode = xpp.getText();
                        }

                        if (tagName.equals("Name")) {
                            textName = xpp.getText();
                        }

                        if (tagName.equals("Value")) {
                            textValue = Double.valueOf(xpp.getText().replace(',', '.'));
                        }
                        break;

                        // если tagName-”NumCode”, сохраняем xpp.getText() в переменной textNumCode
                        // если tagName-”CharCode”, сохраняем xpp.getText() в переменной textCharCode
                        // если tagName-”Name”, сохраняем xpp.getText() в переменной textName
                        // если tagName-”Valute”, сохраняем xpp.getText() в переменной textValute
                        // т. к. при указании курса валюты используется запятая, а для числового //значения в качестве десятичного разделителя требуется точка, то при //преобразовании значения курса в число требуется заменить запятую на точку
//Float.valueOf(xpp.getText().replace(',','.'));

                    }
                    default:
                        break;
                }
                // следующий элемент
                xpp.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    XmlPullParser prepareXpp() throws XmlPullParserException {
        // получаем фабрику
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        // включаем поддержку namespace (по умолчанию выключена)
        factory.setNamespaceAware(true);
        // создаем парсер для уже полученной ранее строки xmlString с содержимым файла
        XmlPullParser xpp = factory.newPullParser();
        // даем парсеру на вход Reader
        xpp.setInput(new StringReader(xmlStr));
        return xpp;
    }

}
