package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.newsapp.network.response.Article
import com.example.newsapp.screens.DetailsScreenUI
import com.example.newsapp.screens.HomeScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = HomeScreen){

        composable<HomeScreen>{
           HomeScreen(navController)
        }

        composable<DetailsScreen>{
            val details = it.toRoute<Article>()
            DetailsScreenUI(details = details)
        }
    }
}
