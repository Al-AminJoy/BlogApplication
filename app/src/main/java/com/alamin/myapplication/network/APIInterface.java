package com.alamin.myapplication.network;


import com.alamin.myapplication.model.Blog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/sohel-cse/simple-blog-api/db")
    Call<Blog> getAllResources();
}
