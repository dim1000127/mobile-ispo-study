package com.example.laba42;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

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

public class Main extends AppCompatActivity {

    private final List<TestValute> testvalute = new ArrayList<>();
    TextView textView, textView2, textView3;
    String date;
    String coeficient;
    MyTask mt;
    String link = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    String xmlString;
    ParserXML parser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        textView = (TextView)findViewById(R.id.tvValuteUsd);
        textView2 = (TextView)findViewById(R.id.tvValuteEur);
        textView3 = (TextView)findViewById(R.id.date_valute);
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        date = df.format(calendar.getTime());
        textView3.setText(date);
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
                    coeficient = response.body().get(0).getCoef();
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

        double coef = Double.valueOf(coeficient);
        for (int i = 0; i < testvalute.size(); i++) {
            if (testvalute.get(i).getValuteCharCode().equals("USD")) {
                textView.setText(
                        String.format("%.2f", coef * testvalute.get(i).getValuteValue() + testvalute.get(i).getValuteValue()));
            }
            if (testvalute.get(i).getValuteCharCode().equals("EUR")) {
                textView2.setText(
                        String.format("%.2f", coef * testvalute.get(i).getValuteValue() + testvalute.get(i).getValuteValue()));
            }
        }
    }

    public void bankomats_Click(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    public void valute_Click(View view){
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }

    public void enter_Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogEnter myDialogFragment = new MyDialogEnter();
        myDialogFragment.show(manager, "myDialogEnter");
    }

}
