package com.doublebyte.kuhaku.ui.screens.details

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.doublebyte.kuhaku.core.network.kuhakuApi.KuhakuRepository
import com.doublebyte.kuhaku.data.kuhakuDTO.GenericResponseDto
import com.doublebyte.kuhaku.data.kuhakuDTO.MoviePreviewDto
import com.doublebyte.kuhaku.ui.components.general.ItemPosterMovieCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val kuhakuRepository: KuhakuRepository
) : ViewModel() {

    // Flow to hold the movie data
    private val _detailScreenInfo = MutableStateFlow<GenericResponseDto<MoviePreviewDto>?>(null)
    val movieDetail: StateFlow<GenericResponseDto<MoviePreviewDto>?> = _detailScreenInfo

    // Function to fetch movies
    fun getDetailScreen(id: String) {
        viewModelScope.launch {
            Log.i("Details gg", "Inicio")
            val movies = kuhakuRepository.getMovieInfo(id)
            Log.i("Details gg", "a")
            _detailScreenInfo.value = movies
            Log.i("Details gg", "b")
            Log.i("Details gg", movies.toString())
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, id : String, viewModel: DetailsScreenViewModel = hiltViewModel()) {
    Scaffold(){
        Body(navController, viewModel,id)
    }
}

@Composable
fun Body(navController: NavController, viewModel: DetailsScreenViewModel, id: String) {
    viewModel.getDetailScreen(id)
    val details by viewModel.movieDetail.collectAsState()
    Log.i("Details gg", "End")


    LazyColumn(){
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(330.dp)){
                ImageBackdropTop(details)
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .height(250.dp)
                        .width(150.dp)){
                    ItemPosterMovieCard("https://image.tmdb.org/t/p/w600_and_h900_bestv2/${details?.payload?.poster_path}")
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
                    .padding(bottom = 10.dp), text = "${details?.payload?.overview}", fontSize = 15.sp)
                HorizontalDivider(Modifier.padding(10.dp))
                //itemSlider("Actores", "https://media.themoviedb.org/t/p/w300_and_h450_bestv2/im9SAqJPZKEbVZGmjXuLI4O7RvM.jpg", true, navController)
            }
        }
    }
}

@Composable
fun ImageBackdropTop(details: GenericResponseDto<MoviePreviewDto>?) {
    Image(
        painter =
        rememberAsyncImagePainter(
            model = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${details?.payload?.backdrop_path}",
        ),
        contentDescription = "ItemIMG",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .blur(10.dp),
        contentScale = ContentScale.Crop
    )
}

