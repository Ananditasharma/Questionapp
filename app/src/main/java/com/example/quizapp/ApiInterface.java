package com.example.quizapp;
import java.sql.Time;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("register.php")
    Call<User> performRegistration(@Query("name") String Name , @Query("user_name") String UserName, @Query("user_password") String UserPassword);

    @GET("login.php")
    Call<User> performUserLogin(@Query("user_name") String UserName, @Query("user_password") String UserPassword);

}
