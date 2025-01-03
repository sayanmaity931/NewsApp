package com.example.newsapp.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
data class DetailsScreen(
    val title: String,
    val description: String,
    val imageUrl: String,
    val content: String,
    val author: String,
    val publishedAt : String
)