package com.example.ysnews.Apis;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_URL = "https://newsapi.org/v2/";


    @GET("top-headlines")
    Call<mainNews> getNews(
            @Query("country") String country, // use same name in ("country")
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );
    @GET("top-headlines")
    Call<mainNews> getCategoryNews(
            @Query("country") String country, // use same name in ("country")
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );
}
