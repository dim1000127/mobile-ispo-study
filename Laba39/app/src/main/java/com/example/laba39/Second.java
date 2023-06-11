package com.example.laba39;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {

    List<Bank> bankNote = new ArrayList<>();
    ListView listView;
    AdapterBank adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        adapter = new AdapterBank(this, bankNote);
        listView = (ListView)findViewById(R.id.lvBank);
        listView.setAdapter(adapter);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        parseJSON();
    }

    public void parseJSON()
    {
        String jsonText = "";
        JSONObject jsonRoot;  //здесь хранится json-объект
        JSONArray jsonArray;  //здесь хранится json-массив

        try {
            jsonText = readText(this, R.raw.bank);  //читаем json-файл, readText приведен ниже
            jsonRoot = new JSONObject(jsonText);  //из строки — содержимого файла создаем программный json-объект
            jsonArray = jsonRoot.getJSONArray("banks"); //извлекаем из json-объекта массив, хранящийся под ключом «banks»
            JSONObject[] banks = new JSONObject[jsonArray.length()];//создаем массив для хранения json-объектов
            for (int i = 0; i < jsonArray.length(); i++) {  //цикл для заполнения массива json-объектов
                banks[i] = jsonArray.getJSONObject(i);  //извлекаем очередной json-объект
                String adr = banks[i].getString("adr");  // извлекаем из json-объекта строковое поле с ключом «adr»
                String start = banks[i].getString("start");
                String fin = banks[i].getString("fin");
                String type = banks[i].getString("type");
                JSONArray tArr = banks[i].getJSONArray("t");
                int[] t = new int[tArr.length()];
                for(int k =0; k < tArr.length(); k++){
                    t[k] = tArr.getInt(k);
                }
                bankNote.add(new Bank(adr, type, start, fin, t));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
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
