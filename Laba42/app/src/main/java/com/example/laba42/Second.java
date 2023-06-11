package com.example.laba42;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Second extends AppCompatActivity {

    ListView listView;
    AdapterBank adapter;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        listView = (ListView)findViewById(R.id.lvBank);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Отделения и банкоматы");
        parseJSON();
    }

    public void parseJSON()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ayayay-ay.ru/wsr_banks/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagesApi messagesApi = retrofit.create(MessagesApi.class);

        Call<List<Bank>> messages = messagesApi.messages();

        messages.enqueue(new Callback<List<Bank>>() {
            @Override
            public void onResponse(Call<List<Bank>> call, Response<List<Bank>> response) {
                if (response.isSuccessful()) {
                    List<Bank> messages = null;
                    messages = response.body();
                    adapter = new AdapterBank(context, messages);
                    listView.setAdapter(adapter);
                } else {
                    Log.d("response code ", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Bank>> call, Throwable t) {
                Log.d("failure ", t.toString());
            }
        });
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
