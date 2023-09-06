package com.abreuhd.kuhaku.components.general

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemPosterCard(img: String) {
    Card(
        onClick = { /* Do something */ },
        modifier = Modifier.size(width = 120.dp, height = 180.dp),
        shape = RoundedCornerShape(12.dp)

    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Image(
                painter =
                    rememberAsyncImagePainter(
                        model = img,
                    ),
                contentDescription = "ItemIMG",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            //Text("Clickable", Modifier.align(Alignment.Center))
        }
    }
}