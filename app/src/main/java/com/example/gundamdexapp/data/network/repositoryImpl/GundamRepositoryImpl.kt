package com.example.gundamdexapp.data.network.repositoryImpl

import com.example.gundamdexapp.data.network.api.GundamApi
import com.example.gundamdexapp.domain.model.GundamInfo
import com.example.gundamdexapp.domain.repository.GundamRepository

class GundamRepositoryImpl(
    private val api: GundamApi
) : GundamRepository {
    override suspend fun getGundamList(): Result<List<GundamInfo>> {
        return try {
            val response = api.getGundams()

            if (response.isSuccessful) {
                val dtoList = response.body() ?: emptyList()

                val domainList = dtoList.map { it.toDomain() }
                Result.success(domainList)
            } else {
                Result.failure(Exception("서버 통신 실패 : ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
