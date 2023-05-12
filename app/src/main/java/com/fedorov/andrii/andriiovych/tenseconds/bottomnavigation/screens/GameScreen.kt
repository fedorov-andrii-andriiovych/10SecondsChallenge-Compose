package com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fedorov.andrii.andriiovych.tenseconds.MainViewModel

@Composable
fun GameScreen(modifier: Modifier, mainViewModel: MainViewModel) {
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp))
                    .fillMaxWidth()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth(),
                    text = "10 Seconds Challenge",
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .padding(24.dp)
                    .clip(shape = RoundedCornerShape(25.dp))
                    .background(Color.Blue)
                    .border(BorderStroke(2.dp, Color.Blue), shape = RoundedCornerShape(25.dp))
            ) {
                Column() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        text = "Best Result",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        text = String.format(
                            "%.9f",
                            mainViewModel.bestResult.value.toDouble() / 1_000_000_000.0
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            Box(
                modifier = Modifier
                    .padding(24.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .wrapContentWidth()
                    .background(Color.White)
                    .border(BorderStroke(2.dp, Color.Blue), shape = RoundedCornerShape(50.dp))
                    .padding(top = 50.dp, bottom = 50.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = if (mainViewModel.elapsedTime.value == "Fail") "Fail" else String.format(
                        "%.9f",
                        mainViewModel.elapsedTime.value.toDouble() / 1_000_000_000.0
                    ),
                    textAlign = TextAlign.Center,
                    color = mainViewModel.textColor.value,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {
                    mainViewModel.resetTimer()
                },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {
                Text(
                    modifier = modifier.padding(top = 16.dp, bottom = 16.dp),
                    text = if (mainViewModel.isRunning.value) "Stop" else "Start",
                    fontSize = 32.sp,
                    color = Color.White
                )
            }
        }
    }
}
