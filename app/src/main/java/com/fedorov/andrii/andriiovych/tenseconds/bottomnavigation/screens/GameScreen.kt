package com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import com.fedorov.andrii.andriiovych.tenseconds.Stopwatch
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun GameScreen() {
    var isRunning by remember { mutableStateOf(false) }
    var elapsedTime by remember { mutableStateOf(0L) }

    Box(
        Modifier
            .background(Color.Cyan)
            .fillMaxSize()
    ) {

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .wrapContentSize(),
                text = "10 Seconds",
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = elapsedTime.toString(),
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {
                    isRunning = !isRunning
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = if (isRunning) "Stop" else "Start",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
    LaunchedEffect(isRunning) {
        val startTime = System.nanoTime()
        while (true) {
            if (isRunning) {
                elapsedTime = System.nanoTime() - startTime
            }
            delay(10)
        }
    }
}
