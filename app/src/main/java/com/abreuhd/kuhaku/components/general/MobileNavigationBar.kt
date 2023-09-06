package com.abreuhd.kuhaku.components.general

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abreuhd.kuhaku.data.NavigationBar.MobileNavigationBarDataClass
import com.abreuhd.kuhaku.routes.AppNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun navigationBarWithScaffold(){
    Scaffold (
        bottomBar = { mobileNavigationBar() }
    ){ padding ->
        AppNavigation(padding)
    }
}

@Preview
@Composable
fun mobileNavigationBar(){
    var selectedItem by remember { mutableStateOf(0) }
    val barItems = listOf(
        MobileNavigationBarDataClass(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "home"
        ),
        MobileNavigationBarDataClass(
            title = "Listas",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            route = "list"
        ),
        MobileNavigationBarDataClass(
            title = "Configuracion",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "config"
        ),
    )

    NavigationBar{
        barItems.forEachIndexed { index, item ->
            val selected = selectedItem == index
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                          //Navigation Logic
                    },
                icon = {
                    Icon(
                        imageVector = if (selectedItem == index) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title)},
                alwaysShowLabel = selected
            )
        }
    }
}