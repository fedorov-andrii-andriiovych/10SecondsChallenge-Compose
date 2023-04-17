package com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.screens.GameScreen
import com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.screens.RatingScreen
import com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.screens.SettingsScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomItem.SCREEN_MAIN
    ) {
        composable(BottomItem.SCREEN_MAIN) {
            GameScreen()
        }
        composable(BottomItem.SCREEN_RATING){
            RatingScreen()
        }
        composable (BottomItem.SCREEN_SETTINGS){
            SettingsScreen()
        }
    }
}