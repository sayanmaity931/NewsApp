package com.example.newsapp.network

import com.example.newsapp.network.response.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiServices {

//    https://newsapi.org/v2/
//    top-headlines?country=us&category=business&apiKey=36f6fd77c5dd4f3faf765f19ecc57d7a

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String = "36f6fd77c5dd4f3faf765f19ecc57d7a"
    ) : Response<NewsModel>

}