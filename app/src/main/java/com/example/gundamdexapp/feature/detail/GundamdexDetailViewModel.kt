package com.example.gundamdexapp.feature.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.gundamdexapp.GundamApplication
import com.example.gundamdexapp.domain.model.GundamInfo
import com.example.gundamdexapp.domain.repository.GundamRepository
import com.example.gundamdexapp.feature.detail.uimodel.ArmamentUiModel
import com.example.gundamdexapp.feature.detail.uimodel.DimensionsUiModel
import com.example.gundamdexapp.feature.detail.uimodel.GundamdexDetailUiModel
import com.example.gundamdexapp.feature.detail.uimodel.IndicatorColor
import com.example.gundamdexapp.feature.detail.uimodel.TechnicalSpecificationsUiModel
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GundamdexDetailViewModel(
    private val id: String,
    private val repository: GundamRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<GundamdexDetailUiState>(GundamdexDetailUiState())
    val uiState: StateFlow<GundamdexDetailUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val gundamInfo = getGundamDetail(id)
            setUiState(gundamInfo)
        }
    }

    suspend fun getGundamDetail(id: String): GundamInfo? {
        return repository.getGundamDetail(id).getOrNull()?.firstOrNull()
    }

    suspend fun setUiState(gundamInfo: GundamInfo?) {
        gundamInfo?.let { gundamInfo ->
            _uiState.update {
                it.copy(
                    id = id,
                    gundamdexDetailUiModel = GundamdexDetailUiModel(
                        modelNumber = gundamInfo.modelNumber,
                        name = gundamInfo.name,
                        series = gundamInfo.series,
                        imageUrl = gundamInfo.imageUrl,
                        era = gundamInfo.era,
                        faction = gundamInfo.faction,
                        pilot = gundamInfo.pilot,
                        description = gundamInfo.description,
                        dimensions = gundamInfo.dimensions.let { data ->
                            DimensionsUiModel(
                                height = data.height,
                                weight = data.weight,
                            )
                        },
                        technicalSpecifications = gundamInfo.technicalSpecifications.let { data ->
                            TechnicalSpecificationsUiModel(
                                generatorOutput = data.generatorOutput,
                                armorMaterial = data.armorMaterial,
                                totalTrust = data.totalTrust,
                                sensorRadius = data.sensorRadius,
                                crew = data.crew,
                            )
                        },
                        armaments = gundamInfo.armaments.let { data ->
                            data.value.map { value ->
                                ArmamentUiModel(
                                    name = value.name,
                                    details = value.details,
                                    indicatorColor = IndicatorColor.dataToIndicatorColor(value.indicatorColor),
                                )
                            }
                        },
                    ),
                )
            }
        } ?: throw IllegalArgumentException("해당 id를 가진 건담에 대한 정보가 존재하지 않습니다.")
    }

    class Factory(private val id: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            val application = checkNotNull(extras[APPLICATION_KEY]) as GundamApplication
            val repository = application.appContainer.gundamRepository

            return GundamdexDetailViewModel(id = id, repository = repository) as T
        }
    }
}
