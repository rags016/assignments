package com.example.unlimit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unlimit.presentation.JokeUIEvent
import com.example.unlimit.presentation.JokeViewModel
import com.example.unlimit.presentation.ui.JokesScreen
import com.example.unlimit.presentation.ui.theme.UnlimitTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val jokeViewModel: JokeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jokeViewModel.handleEvent(JokeUIEvent.GetJoke)

        setContent {
            UnlimitTheme {
                val jokesState by jokeViewModel.jokesState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JokesScreen(jokesState)
                }
            }
        }
    }
}