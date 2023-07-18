package com.example.primeraapp.io;

import com.example.primeraapp.model.DataModal;
import com.example.primeraapp.model.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiService {
    @GET("users")
    Call<ArrayList<Users>>getUsers();

    @POST("users")
    Call<DataModal> createPost(@Body DataModal dataModal);
}