package com.doublebyte.kuhaku.data.NavigationBar

import androidx.compose.ui.graphics.vector.ImageVector

data class MobileNavigationBarDataClass(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
    )
