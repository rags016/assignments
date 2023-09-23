package com.example.unlimit.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.unlimit.core.AnimateSlideHorizontally
import com.example.unlimit.presentation.ui.theme.Typography

@Composable
fun JokesScreen(jokes: List<String>) {
    val scrollState = rememberLazyListState()
    Column {
        JokeTopBar()
        LazyColumn(state = scrollState, modifier = Modifier.fillMaxSize()) {
            items(jokes.size, key = { it }) { index ->
                JokeItem(jokes[index])
            }
        }
    }
}

@Composable
fun JokeTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .background(color = Color.Gray)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Jokes",
                style = Typography.titleLarge,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun JokeItem(jokeText: String) {
    AnimateSlideHorizontally(
        delayInMillis = 100,
        durationInMillis = 1000
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.LightGray)
        ) {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = jokeText,
                    style = Typography.titleMedium,
                    color = Color.Black
                )
            }
        }
    }
}
