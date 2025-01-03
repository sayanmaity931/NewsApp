package com.example.newsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.newsapp.R
import com.example.newsapp.navigation.DetailsScreen


@Composable
fun HomeScreen(navController: NavHostController) {

    val viewModel = NewsViewModel()

    val data = viewModel.data.value?.articles?: emptyList()

    if(data.isEmpty()) {
        Text(text = "No data available", modifier = Modifier.padding(16.dp))
    }
    else {
        LazyColumn {
            items(data) {
                CardItems(
                    title = it.title,
                    description = it.description,
                    imageUrl = it.urlToImage,
                    content = it.content,
                    author = it.author,
                    publishedAt = it.publishedAt,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun CardItems(
    title: String? ,
    description: String? ,
    imageUrl: String? = "",
    content : String? = "",
    author : String? = "",
    publishedAt : String? = "",
    navController: NavHostController
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .height(100.dp)
            .padding(8.dp)
            .clickable (
                onClick = {
                    navController.navigate(DetailsScreen(title = title?: "", description = description?: "", imageUrl = imageUrl?: "", content = content?: "", author = author?: "", publishedAt = publishedAt?: ""))
                },
                enabled = true
            )
            ,
            verticalAlignment = Alignment.CenterVertically

        ){
            SubcomposeAsyncImage(
                model = imageUrl,
                loading = { CircularProgressIndicator(modifier = Modifier.size(10.dp)) },
                contentDescription = "Image",
                error = {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Placeholder Image",
                        modifier = Modifier.size(150.dp)
                    )
                },
                modifier = Modifier.size(150.dp).padding(end = 8.dp)
            )

            Column {
                Text(text = title?: "no title available")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = description?: "no description available",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

