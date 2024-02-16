package com.doublebyte.kuhaku.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.doublebyte.kuhaku.ui.components.general.itemSearchBar
import com.doublebyte.kuhaku.ui.components.general.itemSlider

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