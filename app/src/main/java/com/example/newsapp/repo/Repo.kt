package com.example.newsapp.repo

import com.example.newsapp.network.apiProvider

class Repo {

    suspend fun getNewsRepo() = apiProvider.provideApi().getNews()

}