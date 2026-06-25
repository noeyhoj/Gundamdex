package com.example.gundamdexapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.gundamdexapp.GundamApplication
import com.example.gundamdexapp.domain.repository.GundamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GundamdexHomeViewModel(
    private val gundamRepository: GundamRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<GundamdexHomeUiState>(GundamdexHomeUiState())
    val uiState: StateFlow<GundamdexHomeUiState> = _uiState.asStateFlow()

    init {
        getGundamList()
    }

    fun getGundamList() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    gundamInfoList = gundamRepository.getGundamList()
                        .getOrThrow().map { gundamInfo ->
                            GundamdexHomeUiModel(
                                id = gundamInfo.id,
                                modelNumber = gundamInfo.modelNumber,
                                name = gundamInfo.name,
                                series = gundamInfo.series,
                                imageUrl = gundamInfo.imageUrl,
                            )
                        },
                )
            }
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as GundamApplication
                val repository = application.appContainer.gundamRepository

                GundamdexHomeViewModel(gundamRepository = repository)
            }
        }
    }
}
