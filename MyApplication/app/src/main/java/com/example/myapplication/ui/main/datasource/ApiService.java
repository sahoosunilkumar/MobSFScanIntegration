package com.example.myapplication.ui.main.datasource;

import com.example.myapplication.ui.main.model.Todo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET("todos/1")
    Single<Todo> getTodo();
    @GET
    Single<Todo> getUsers(@Url String url);
}
