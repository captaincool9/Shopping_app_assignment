package com.example.shoppingapp.di

import com.example.shoppingapp.network.PopularMovieInterface
import com.example.shoppingapp.network.base_url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Create a Hilt module
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePopularMovieInterface(retrofit: Retrofit): PopularMovieInterface {
        return retrofit.create(PopularMovieInterface::class.java)
    }
}
