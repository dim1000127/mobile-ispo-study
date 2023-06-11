package com.example.laba42;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class MyTask extends AsyncTask<String, Void, String> {

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... urls) {
        String answer = "";
        try{
            answer=dowloadFile(urls[0]);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        //возвращаем строку — содержимое файла
        return answer;
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }

    // метод, возвращающий содержимое файла по его url
    private String dowloadFile(String url) throws InterruptedException{
        String myText = "";
        try {
            URL myUrl = new URL(url); //My text file location
            //First open the connection
            HttpURLConnection conn=(HttpURLConnection) myUrl.openConnection();
            conn.setConnectTimeout(60000); // timing out in a minute
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "windows-1251"));

            String str;
            while ((str = in.readLine()) != null) {
                myText+=str;
            }
            in.close();


        } catch (Exception e) {
            Log.d("MyTag",e.toString());
        }
        return myText;
    }
}
