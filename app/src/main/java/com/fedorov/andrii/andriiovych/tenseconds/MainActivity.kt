package com.fedorov.andrii.andriiovych.tenseconds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.MainScreen
import com.fedorov.andrii.andriiovych.tenseconds.ui.theme.TenSecondsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TenSecondsTheme {
                    MainScreen()
                }
            }
        }
    }


