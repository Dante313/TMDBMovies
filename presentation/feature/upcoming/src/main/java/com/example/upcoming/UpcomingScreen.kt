package com.example.upcoming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.data.models.Movie
import com.example.upcoming.viewmodel.LoadState
import com.example.upcoming.viewmodel.UpcomingState
import com.example.upcoming.viewmodel.UpcomingViewModel
import java.util.*

@Composable
internal fun UpcomingScreen(
    viewModel: UpcomingViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UpcomingScreen(
        state = state
    )
}

@Composable
private fun UpcomingScreen(
    state: UpcomingState
) {
    when (state.loadState) {
        LoadState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        LoadState.Loaded -> {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(count = state.movies.movies.size) { index ->
                    UpcomingItem(state.movies.movies[index])
                }
            }
        }
        LoadState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column {
                    state.errorMessage?.let {
                        Text(text = it)
                    }
                }
            }
        }
        LoadState.NoResults -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                state.errorMessage?.let { Text(text = it) }
            }
        }
        else -> Unit
    }
}

@Composable
fun UpcomingItem(movie: Movie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .height(180.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Box {
            val context = LocalContext.current

            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.Center,
                model = ImageRequest.Builder(context)
                    .data(movie.imageUrl)
                    .placeholder(ContextCompat.getDrawable(context, R.drawable.ic_placeholder))
                    .error(ContextCompat.getDrawable(context, R.drawable.ic_placeholder))
                    .crossfade(300)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(Color.Transparent, Color.Black),)
                )
            ) {
                Column(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = movie.title,
                    )
                    Text(
                        text = movie.releaseYear
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpcomingItemPreview() {
    val releaseDate = Calendar.getInstance()
    releaseDate.set(1992, 2, 23)

    val movie = Movie(
        imageUrl = "https://cdn.shazoo.ru/652725_wIpwBgu_mv5bythhmmmyywetn2nkyi00odqxltg1zjctmmjjymqzzjm3y2jixkeyxkfqcgdeqxvynjm5odq2mdk-at-v1-fmjpg-ux1000.jpg",
        releaseDate = releaseDate,
        releaseYear = "1992",
        title = "Gayniggers from outer space"
    )

    UpcomingItem(movie)
}