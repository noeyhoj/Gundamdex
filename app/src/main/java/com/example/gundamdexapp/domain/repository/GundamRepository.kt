package com.example.gundamdexapp.domain.repository

import com.example.gundamdexapp.domain.model.GundamInfo

interface GundamRepository {
    suspend fun getGundamList(): Result<List<GundamInfo>>
    suspend fun getGundamDetail(id: String): Result<List<GundamInfo>>
}
