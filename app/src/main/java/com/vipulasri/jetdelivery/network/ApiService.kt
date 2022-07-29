package com.vipulasri.jetdelivery.network

import com.vipulasri.jetdelivery.network.model.Dashboard
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("1199ed96ed2d4b688ea981d2d989c883/raw/data-random-1")
    suspend fun getRandomOneDashboard(): Dashboard

    @GET("1c12ab1898d2fd06c1f730b9ecb624e4/raw/data-random-2")
    suspend fun getRandomTwoDashboard(): Dashboard

    @GET("ed57419d302efe9590642ac8bc94aa0f/raw/data-random-3")
    suspend fun getRandomThreeDashboard(): Dashboard

    @GET("990da06c9ccae28dbc61208a27133ceb/raw/data-random-4")
    suspend fun getRandomFourDashboard(): Dashboard

}

object NetworkClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)

    val service: ApiService by lazy {
        retrofit.baseUrl("https://gist.githubusercontent.com/ahmedadeltito/")
            .build().create(ApiService::class.java)
    }

}