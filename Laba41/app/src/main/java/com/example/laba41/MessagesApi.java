package com.example.laba41;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesApi {

    @GET("bankomats")
    Call<List<Bank>> messages();

}
