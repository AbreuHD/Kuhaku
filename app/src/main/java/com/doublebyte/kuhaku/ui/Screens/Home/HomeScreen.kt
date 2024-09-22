package com.doublebyte.kuhaku.ui.screens.home

import android.graphics.Movie
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.doublebyte.kuhaku.core.network.kuhakuApi.KuhakuRepository
import com.doublebyte.kuhaku.data.kuhakuDTO.GenericResponseDto
import com.doublebyte.kuhaku.data.kuhakuDTO.HomePageDto
import com.doublebyte.kuhaku.ui.components.navigation.itemSearchBar
import com.doublebyte.kuhaku.ui.components.general.itemSlider
import com.doublebyte.kuhaku.ui.components.navigation.MobileNavigationBar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.lang.System.console
import javax.inject.Inject
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val kuhakuRepository: KuhakuRepository
) : ViewModel() {

    // Flow to hold the movie data
    private val _homePageMovies = MutableStateFlow<GenericResponseDto<List<HomePageDto>>?>(null)
    val homePageMovies: StateFlow<GenericResponseDto<List<HomePageDto>>?> = _homePageMovies

    // Function to fetch movies
    fun getHomeScreenMovies(kidMode: Boolean) {
        viewModelScope.launch {
            val movies = kuhakuRepository.getHomePageMovies(kidMode)
            _homePageMovies.value = movies
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel = hiltViewModel()) {
    Scaffold(topBar = { itemSearchBar() }, bottomBar = { MobileNavigationBar() }) { padding ->
        Body(navController = navController, padding, viewModel)
    }
}

@Composable
fun Body(navController: NavController, padding: PaddingValues, viewModel: HomeScreenViewModel) {
    viewModel.getHomeScreenMovies(false)
    val movies by viewModel.homePageMovies.collectAsState()
    Log.i("Movies", "Success: ${movies?.payload?.size}")
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 80.dp, bottom = 80.dp)
    ) {
        movies?.payload?.let {
            items (it.size) { i ->
                Log.i("Movies", "Success:" + movies?.payload!![i].movies.map { it?.poster_path})
                itemSlider(
                    movies!!.payload[i].genre.name,
                    movies!!.payload[i].movies.map { "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${it?.poster_path}"},
                    false,
                    navController
                )
            }
        }
    }
}

