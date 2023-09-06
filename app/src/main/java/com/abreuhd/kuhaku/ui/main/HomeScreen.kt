package com.abreuhd.kuhaku.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abreuhd.kuhaku.components.general.ItemPosterCard
import com.abreuhd.kuhaku.components.general.itemSearchBar
import com.abreuhd.kuhaku.components.general.itemSlider

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(navController: NavController, padding: PaddingValues) {
    Scaffold ( topBar = { itemSearchBar() } ) {padding ->
        Body(navController = navController, padding)
    }

}
@Composable
fun Body(navController: NavController, padding: PaddingValues){
    LazyColumn(modifier = Modifier.fillMaxHeight().padding(top = 80.dp, bottom = 80.dp)){
        items(10){
            itemSlider()
        }
    }
}