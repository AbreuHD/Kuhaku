package com.doublebyte.kuhaku.ui.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.doublebyte.kuhaku.ui.components.general.ItemPosterMovieCard
import com.doublebyte.kuhaku.ui.components.general.itemSlider


@Preview
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController = navController)
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController) {
    Scaffold(){
        Body(navController)
    }
}

@Composable
fun Body(navController: NavController) {
    LazyColumn(){
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(330.dp)){
                ImageBackdropTop()
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .height(250.dp)
                        .width(150.dp)){
                    ItemPosterMovieCard("https://image.tmdb.org/t/p/w600_and_h900_bestv2/ugX4WZJO3jEvTOerctAWJLinujo.jpg")
                }

                Box(Modifier.align(Alignment.BottomCenter)){
                    ElevatedButton(modifier =
                    Modifier
                        .size(150.dp, 50.dp)
                        .align(Alignment.BottomCenter)
                        .align(Alignment.Center),
                        onClick = {
                            /*TODO*/
                        }) {
                        //Text(text = "Reproducir", fontSize = 15.sp)
                        Icon(Icons.Filled.PlayArrow, contentDescription = "Play BTN")
                    }
                }
            }
            Column {
                Text(text = "Descripcion", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp))

                Spacer(modifier = Modifier.defaultMinSize(10.dp))
                Text(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 10.dp), text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", fontSize = 15.sp)
                Divider(Modifier.padding(10.dp))
                //itemSlider("Actores", "https://media.themoviedb.org/t/p/w300_and_h450_bestv2/im9SAqJPZKEbVZGmjXuLI4O7RvM.jpg", true, navController)
            }
        }
    }
}

@Composable
fun ImageBackdropTop() {
    Image(
        painter =
        rememberAsyncImagePainter(
            model = "https://image.tmdb.org/t/p/original/gHLs7Fy3DzLmLsD4lmfqL55KGcl.jpg",
        ),
        contentDescription = "ItemIMG",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .blur(10.dp),
        contentScale = ContentScale.Crop
    )
}

