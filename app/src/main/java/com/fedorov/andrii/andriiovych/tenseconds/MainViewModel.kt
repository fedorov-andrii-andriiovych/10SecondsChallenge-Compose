package com.fedorov.andrii.andriiovych.tenseconds

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Math.abs

class MainViewModel:ViewModel(){
    var bestResult = mutableStateOf("0")
    var isRunning =  mutableStateOf(false)
    var elapsedTime =  mutableStateOf("0")
    var textColor = mutableStateOf(Color.Black)

    fun startTimer() = viewModelScope.launch(Dispatchers.Default){
        val startTime = System.nanoTime()
        if(isRunning.value) {
            textColor.value = Color.Black
        }
        while (isRunning.value) {
            if (isRunning.value) {
                val time = System.nanoTime() - startTime
                elapsedTime.value = time.toString()
                    if (time > 10000000000) {
                        textColor.value =Color.Red
                        if (time>11000000000){
                            textColor.value =Color.Red
                            elapsedTime.value = "Fail"
                            isRunning.value = false
                        }
                    }
            }
            delay(10)
        }
    }

    fun resetTimer(){
        isRunning.value = !isRunning.value
        if (elapsedTime.value != "Fail") {
            val time = kotlin.math.abs(bestResult.value.toLong() - 10000000000)
            val eTime = kotlin.math.abs(elapsedTime.value.toLong() - 10000000000)
            if (eTime < time) bestResult.value = elapsedTime.value
        }
        startTimer()
    }


}