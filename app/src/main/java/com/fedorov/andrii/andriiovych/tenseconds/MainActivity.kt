package com.fedorov.andrii.andriiovych.tenseconds

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.MainScreen
import com.fedorov.andrii.andriiovych.tenseconds.ui.theme.TenSecondsTheme

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        sp = getSharedPreferences("sp", MODE_PRIVATE)
        setContent {
            TenSecondsTheme {
                    MainScreen()
                }
            }
        }

    override fun onPause() {
        super.onPause()
        sp.edit().putString(BEST_RESULT,viewModel.bestResult.value).apply()
    }

    override fun onResume() {
        super.onResume()
        val result = sp.getString(BEST_RESULT,"0")
        viewModel.bestResult.value = result!!
    }


    companion object{
        const val BEST_RESULT = "bestResult"
    }
    }








