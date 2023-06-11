package com.example.laba38;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.text.TextUtils.concat;

public class Main extends AppCompatActivity {
    private final List<TestValute> testvalute = new ArrayList<>();
    Adapter adapter;
    ListView listView;
    Button button;
    private final double coef = 0.01f;
    String date = "06/03/2021";
    String link = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    String xmlString;
    MyTask mt;
    ParserXML parser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        listView = (ListView) findViewById(R.id.lv);
        button = (Button) findViewById(R.id.buttonDate);
        adapter = new Adapter(this, testvalute, coef);
        listView.setAdapter(adapter);
        String tmp = "";
        parse();

    }

    public void dateClick(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialog myDialogFragment = new MyDialog();
        myDialogFragment.show(manager, "myDialog");
    }

    public void setDate(int year, int month, int day){
        String yearS = String.valueOf(year);
        month++;
        String monthS = String.valueOf(month);
        String dayS = String.valueOf(day);

        if (month<10){
            monthS = "0" + month;
        }

        if (day<10){
            dayS = "0" + day;
        }

        date = dayS+"/"+monthS+"/"+yearS;
        String dateForBtn = date.replace('/','.');
        button.setText(dateForBtn);
        testvalute.clear();
        parse();
        listView.invalidateViews();
    }

    public void parse(){
        mt = new MyTask();
        mt.execute(link.concat(date));
        try{
            xmlString=mt.get(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
        catch (TimeoutException e){
            e.printStackTrace();
        }
        parser = new ParserXML(xmlString, testvalute);
    }
}
