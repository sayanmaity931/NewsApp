package com.example.newsapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.newsapp.R
import com.example.newsapp.network.response.Article

@Composable
fun DetailsScreenUI(modifier: Modifier = Modifier , details : Article) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {


        item { // Article Image (using coil)
            val painter = rememberAsyncImagePainter(
                model = details.urlToImage,
                placeholder = painterResource(id = R.drawable.pin), // Add a placeholder
                error = painterResource(id = R.drawable.ic_launcher_foreground) // Add an error placeholder
            )
            Image(
                painter = painter,
                contentDescription = "Article Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            // Article Title
            Text(
                text = details.title,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            // Article Author and Date
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (details.author != null) {
                    Text(
                        text = details.author,
                        style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 14.sp),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = details.publishedAt,
                    style = TextStyle(fontSize = 12.sp, color = Color.Gray),
                    modifier = Modifier.weight(1f),
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // Article Description
            if (details.description.isNotBlank()) {
                Text(
                    text = details.description,
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

        }

        item {
            // Article Content
            Text(
                text = details.content,
                style = TextStyle(fontSize = 16.sp, lineHeight = 24.sp),
                modifier = Modifier.fillMaxWidth(),
                // maxLines = 20
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            //Divider Line
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            // Source
            Text(
                text = "Source: ${details.source.name}",
                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}