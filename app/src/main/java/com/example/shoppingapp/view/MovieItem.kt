package com.example.shoppingapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.shoppingapp.data.model.MovieResult
import com.example.shoppingapp.viewmodel.MovieViewModel

@Composable
@OptIn(ExperimentalCoilApi::class)

fun MovieItem(
    movie: MovieResult,
    movieViewModel: MovieViewModel = hiltViewModel()
) {

    //var expanded by remember { mutableStateOf(false) }
    // var dialogVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = rememberImagePainter(
                    data = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                    builder = {}),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = movie.original_title,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Release date:${movie.release_date}",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Original Language:${movie.original_language}",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Overview: ${movie.overview}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}
