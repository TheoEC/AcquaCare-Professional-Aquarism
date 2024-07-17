package com.tmpsolutions.ui.aquariumParameters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmpsolutions.domain.model.parameters.AquariumParameter
import com.tmpsolutions.domain.model.parameters.CommonParameters
import com.tmpsolutions.domain.model.parameters.ParameterType
import com.tmpsolutions.domain.model.parameters.parameters
import com.tmpsolutions.domain.usecase.parameters.GetAquariumParametersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ParametersViewModel(
    val aquariumID: Int,
    val getAquariumParametersUseCase: GetAquariumParametersUseCase,
    val addParameterToAquariumUseCase: AddParameterToAquariumUseCase
) : ViewModel() {
    var aquariumParameters = emptyList<AquariumParameter>()

    private val _state = MutableSharedFlow<ParameterState>(replay = 1)
    val state : SharedFlow<ParameterState> = _state

    init {
        loadParameters()
    }

    private fun loadParameters() {
        viewModelScope.launch {
            getAquariumParametersUseCase(aquariumID)
                .flowOn(Dispatchers.IO)
                .onStart { _state.emit(ParameterState.Loading) }
                .catch { error ->
                    _state.emit(ParameterState.Error(error.message.toString()))
                }
                .collect { parametersList ->
                    aquariumParameters = parametersList

                    _state.emit(ParameterState.Success(parametersList))
                }
        }
    }

    fun getMissingParameterTypes() : List<ParameterType> {
        val result = parameters.toMutableList()

        val parametersIds = aquariumParameters.map { it.type?.id ?: -1 }

        result.removeAll{ parameterType ->
            parameterType.id in parametersIds
        }
        return result
    }
}