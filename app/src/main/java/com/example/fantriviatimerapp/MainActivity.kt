package com.example.fantriviatimerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fantriviatimerapp.ui.theme.FanTriviatimerGameComposeTheme
import com.example.fantriviatimerapp.viewmodel.TriviaTimerViewModel

class MainActivity : ComponentActivity() {

    private val triviaTimerViewModel: TriviaTimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        triviaTimerViewModel.startTimer(10)  // start countdown

        setContent {
            FanTriviatimerGameComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TimerScreen(triviaTimerViewModel)
                }
            }
        }
}
@Composable
fun TimerScreen(viewModel: TriviaTimerViewModel) {
    val timeLeft by viewModel.timeLeft.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = timeLeft.toString(),
            fontSize = 60.sp,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { viewModel.startTimer(10) }) {
            Text("Restart Timer")
        }
    }
}
}