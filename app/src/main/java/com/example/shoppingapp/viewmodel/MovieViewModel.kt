package com.example.shoppingapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.data.model.MovieResult
import com.example.shoppingapp.data.model.PopularMovie
import com.example.shoppingapp.network.PopularMovieService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val popularMovieService: PopularMovieService
) : ViewModel() {
    private val _movies = MutableStateFlow<List<MovieResult>>(emptyList())
    val movies = _movies.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun getPopularMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val movieVar = popularMovieService.popularMovieInterface.getMovies(apiKey)
                Log.d("Hello", "API Request URL: ${movieVar.request().url()}")
                movieVar.enqueue(object : Callback<PopularMovie> {
                    override fun onResponse(
                        call: Call<PopularMovie>,
                        response: Response<PopularMovie?>
                    ) {
                        if (response.isSuccessful) {
                            val movies = response.body()?.results ?: emptyList()
                            Log.d("Hello", "API Response: $response")
                            Log.d("Hello", "Movies from API: $movies")
                            Log.d("Hello", "Movies updated: ${_movies.value.size}")
                            _movies.value = movies
                        }
                    }

                    override fun onFailure(call: Call<PopularMovie?>, t: Throwable) {
                        Log.d("Hello", "Error in fetching ${t.localizedMessage}")
                    }
                })

            } catch (e: Exception) {
                Log.d("Error", "Exception ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}