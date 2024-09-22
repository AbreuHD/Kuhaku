package com.doublebyte.kuhaku.core.routes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.doublebyte.kuhaku.Routes.AppScreens
import com.doublebyte.kuhaku.ui.screens.details.DetailsScreen
import com.doublebyte.kuhaku.ui.screens.home.HomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.DetailScreen.route){
            DetailsScreen(navController)
        }
    }

}