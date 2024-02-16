package com.doublebyte.kuhaku.Routes

sealed class AppScreens(val route: String){
    object HomeScreen: AppScreens("home")
}
