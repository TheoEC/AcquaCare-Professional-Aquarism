package com.tmpsolutions.ui.AquariumDetails

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.tmpsolutions.data.db
import com.tmpsolutions.data.repository.AquariumRepositoryImpl
import com.tmpsolutions.domain.usecase.GetAquariumUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AquariumDetailViewModel(
    private val aquariumID : Int,
    val getAquariumUseCase : GetAquariumUseCase
) : ViewModel() {
    private val _state = MutableSharedFlow<AquariumDetailState>(replay = 1)
    val state : SharedFlow<AquariumDetailState> = _state

    init {
        viewModelScope.launch {
            getAquariumUseCase(aquariumID)
                .flowOn(Dispatchers.Main)
                .onStart { _state.emit(AquariumDetailState.Loading) }
                .catch {  error ->
                    //TODO Log.e(...)
                    _state.emit(AquariumDetailState.Error(error.message.toString()))
                }
                .collect { aquarium ->
                    _state.emit(AquariumDetailState.Success(aquarium))
                }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val context: Context,
        private val aquariumID: Int
        ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val repository = AquariumRepositoryImpl(context.db.AquariumDao())

            return AquariumDetailViewModel(aquariumID, GetAquariumUseCase(repository)) as T
        }
    }
}