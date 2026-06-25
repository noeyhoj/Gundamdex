package com.example.gundamdexapp.data.network.repositoryImpl

import com.example.gundamdexapp.data.network.api.GundamApi
import com.example.gundamdexapp.domain.model.GundamInfo
import com.example.gundamdexapp.domain.repository.GundamRepository

class GundamRepositoryImpl(
    private val api: GundamApi,
) : GundamRepository {
    override suspend fun getGundamList(): Result<List<GundamInfo>> = try {
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

    override suspend fun getGundamDetail(id: String): Result<List<GundamInfo>> = try {
        val response = api.getGundamDetail(idFilter = "eq.$id")

        if (response.isSuccessful) {
            val gundamDto = response.body() ?: emptyList()

            val domainList = gundamDto.map { it.toDomain() }
            Result.success(domainList)
        } else {
            Result.failure(Exception("서버 통신 실패 : ${response.code()}"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}
