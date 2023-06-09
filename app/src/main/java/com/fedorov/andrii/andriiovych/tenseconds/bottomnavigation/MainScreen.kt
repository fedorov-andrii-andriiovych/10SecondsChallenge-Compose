package com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.fedorov.andrii.andriiovych.tenseconds.MainViewModel


@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        Box(Modifier.padding(bottom = it.calculateBottomPadding())){
            NavGraph(navHostController = navController)
        }

    }
}