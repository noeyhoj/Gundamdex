package com.example.gundamdexapp.domain.repository

import com.example.gundamdexapp.domain.model.GundamInfo

interface GundamRepository {
    suspend fun getGundamList(): Result<List<GundamInfo>>
}
