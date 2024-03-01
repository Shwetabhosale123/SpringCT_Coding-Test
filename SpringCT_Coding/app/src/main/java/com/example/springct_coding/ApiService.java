package com.example.springct_coding;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService
{
    @FormUrlEncoded
    @POST("api/login")
    Call<JSONObject>login(@Field("email") String email, @Field("password") String password);
}
