package com.abreuhd.kuhaku.routes

sealed class AppScreens(val route: String){
    object HomeScreen: AppScreens("home")
}
