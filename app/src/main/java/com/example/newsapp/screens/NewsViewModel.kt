package com.example.newsapp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.network.response.NewsModel
import com.example.newsapp.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    val repo = Repo()

    val data =  mutableStateOf<NewsModel?>(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsViewModel()
        }
    }

    suspend fun getNewsViewModel() {
        data.value = repo.getNewsRepo().body()
    }
}