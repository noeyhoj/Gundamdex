package com.example.gundamdexapp.data.network.api

import com.example.gundamdexapp.BuildConfig
import com.example.gundamdexapp.data.network.dto.GundamDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GundamApi {
    @GET("rest/v1/gundams")
    suspend fun getGundams(
        @Header("apikey") apikey: String = BuildConfig.SUPABASE_ANON_KEY,
        @Header("Authorization") auth: String = "Bearer ${BuildConfig.SUPABASE_ANON_KEY}",
        @Query("select") selectQuery: String = "*, armaments(*)",
    ): Response<List<GundamDto>>

    @GET("rest/v1/gundams")
    suspend fun getGundamDetail(
        @Header("apikey") apikey: String = BuildConfig.SUPABASE_ANON_KEY,
        @Header("Authorization") auth: String = "Bearer ${BuildConfig.SUPABASE_ANON_KEY}",
        @Query("id") idFilter: String,
        @Query("select") selectQuery: String = "*, armaments(*)",
    ): Response<List<GundamDto>>
}
