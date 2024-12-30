package com.example.newsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.newsapp.screens.NewsViewModel

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun Test(){

        val viewModel = NewsViewModel()
        val data = viewModel.data.value?.articles?: emptyList()

        Text(text = data.toString())

        LazyColumn {

            items(data) {
                CardItems(title = it.title,
                    description = it.description,
                    imageUrl = it.urlToImage)
            }
        }

    }

    @Composable
    fun CardItems(
        title: String? ,
        description: String? ,
        imageUrl: String? = ""
    ){
        Card(
            modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.Blue)
        ) {
            Row(modifier = Modifier.fillMaxSize()
                .padding(8.dp)
                .height(100.dp)
                .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                SubcomposeAsyncImage(
                    model = imageUrl,
                    loading = { CircularProgressIndicator() },
                    contentDescription = ""
                )

                Column {
                    Text(text = title?: "no title available")
                    Text(text = description?: "no description available")
                }
            }
        }
    }

