package com.example.shoppingapp.network

import com.example.shoppingapp.data.model.PopularMovie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

const val base_url = "https://api.themoviedb.org/3/"

interface PopularMovieInterface {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<PopularMovie>
}

@Singleton
class PopularMovieService @Inject constructor(retrofit: Retrofit) {
    val popularMovieInterface: PopularMovieInterface =
        retrofit.create(PopularMovieInterface::class.java)
}
