package com.example.laba36;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private final List<TestValute>  testvalute = new ArrayList<>();
    Adapter adapter;
    ListView listView;
    String tagName, textCharCode, textName;
    double textValue;
    int textNumCode;
    private final double coef = 0.1f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        listView = (ListView)findViewById(R.id.lv);
        adapter = new Adapter(this, testvalute, coef);
        listView.setAdapter(adapter);
        String tmp = "";

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

    XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.data);
    }
}
