package com.doublebyte.kuhaku.ui.components.general

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.doublebyte.kuhaku.data.kuhakuDTO.MoviePreviewDto

@Composable
fun itemSlider(txt: String, movieList: List<MoviePreviewDto?>, isPerson: Boolean = false, navController: NavController) {
    //Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = txt,
            modifier = Modifier.padding(start = 16.dp),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
            )
        Box(modifier = Modifier
            //.weight(1f)
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)) {
            // Scrollable Row of Cards
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(movieList.size) { i ->
                    ItemPosterCard(movieList[i]!!.poster_path, isPerson, navController, movieList[i]?.id.toString())
                }
            }
        //}
    }
}