package com.example.laba42;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Third extends AppCompatActivity {

    private final List<TestValute> testvalute = new ArrayList<>();
    private final List<TestValute> testvalute2 = new ArrayList<>();
    Adapter adapter;
    ListView listView;
    Button button;
    double coeficient;
    String date = "06/03/2021";
    String date2 = "06/03/2021";
    String link = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    String xmlString;
    MyTask mt;
    MyTask mt2;
    ParserXML parser;
    ParserXML parser2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Курсы валют");
        button = (Button) findViewById(R.id.buttonDate);
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        date = df.format(calendar.getTime());
        calendar.add(Calendar.DATE, -1);
        date2 = df.format(calendar.getTime());
        button.setText(date);
        listView = (ListView) findViewById(R.id.lv);
        parseJSON();
    }

    public void parseJSON()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ayayay-ay.ru/wsr_banks/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagesApi coefApi = retrofit.create(MessagesApi.class);

        Call<List<Coef>> coef = coefApi.coefs();

        coef.enqueue(new Callback<List<Coef>>() {
            @Override
            public void onResponse(Call<List<Coef>> call, Response<List<Coef>> response) {
                if (response.isSuccessful()) {
                    coeficient = Double.valueOf(response.body().get(0).getCoef());
                    parse();
                } else {
                    Log.d("response code ", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Coef>> call, Throwable t) {
                Log.d("failure ", t.toString());
            }
        });
    }

    public void dateClick(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialog myDialogFragment = new MyDialog();
        myDialogFragment.show(manager, "myDialog");
    }

    public void setDate(int year, int month, int day){
        String yearS = String.valueOf(year);
        month++;
        int day2 = day-1;
        String monthS = String.valueOf(month);
        String dayS = String.valueOf(day);
        String dayS2 = String.valueOf(day2);

        if (month<10){
            monthS = "0" + month;
        }

        if (day<10){
            dayS = "0" + day;
        }

        if (day2<10){
            dayS2 = "0" + day2;
        }

        date = dayS+"/"+monthS+"/"+yearS;
        date2 = dayS2+"/"+monthS+"/"+yearS;
        String dateForBtn = date.replace('/','.');
        button.setText(dateForBtn);
        testvalute.clear();
        testvalute2.clear();
        parse();
        listView.invalidateViews();
    }

    public void parse(){
        mt = new MyTask();
        mt.execute(link.concat(date));
        try{
            xmlString=mt.get(1, TimeUnit.SECONDS);
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
        adapter = new Adapter(this, testvalute, testvalute2,coeficient);
        listView.setAdapter(adapter);
        parse2();
    }

    public void parse2(){
        mt2 = new MyTask();
        mt2.execute(link.concat(date2));
        try{
            xmlString=mt2.get(1, TimeUnit.SECONDS);
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
        parser2 = new ParserXML(xmlString, testvalute2);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
