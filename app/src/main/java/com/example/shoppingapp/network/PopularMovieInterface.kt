package com.example.shoppingapp.network

import com.example.shoppingapp.data.model.PopularMovie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val base_url="https://api.themoviedb.org/3/"
interface PopularMovieInterface {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<PopularMovie>
}
object PopularMovieService{
    val popularMovieInterface : PopularMovieInterface
    init {
        val retro=
            Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()
        popularMovieInterface=retro.create(PopularMovieInterface::class.java)
    }
}
