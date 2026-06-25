package com.example.gundamdexapp.data.network

import com.example.gundamdexapp.BuildConfig
import com.example.gundamdexapp.data.network.api.GundamApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object SupabaseNetwork {
    // Logcat에서 통신 로그를 보기 위한 설정
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("${BuildConfig.SUPABASE_URL}/")
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val gundamApi: GundamApi = retrofit.create(GundamApi::class.java)
}
