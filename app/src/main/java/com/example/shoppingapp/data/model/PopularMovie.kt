package com.example.shoppingapp.data.model

data class PopularMovie(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)