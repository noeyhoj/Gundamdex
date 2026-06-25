package com.example.gundamdexapp.data.network

import com.example.gundamdexapp.data.network.repositoryImpl.GundamRepositoryImpl
import com.example.gundamdexapp.domain.repository.GundamRepository

class AppContainer {
    val gundamRepository: GundamRepository by lazy {
        GundamRepositoryImpl(SupabaseNetwork.gundamApi)
    }
}
