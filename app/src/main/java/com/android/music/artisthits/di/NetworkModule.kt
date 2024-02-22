package com.android.music.artisthits.di

import com.android.music.artisthits.api.ArtistHitsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule{


    //retrofit object
    @Singleton
    @Provides
    fun retrofitObjectProvider() : Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    //api object where i pass retrofit upper object in hilt
    @Singleton
    @Provides
    fun retrofitApiObjectProvider(retrofit: Retrofit) : ArtistHitsApi {
        return retrofit.create(ArtistHitsApi::class.java)
    }

}