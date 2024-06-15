package com.tmpsolutions.ui.MainScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.tmpsolutions.data.db
import com.tmpsolutions.data.repository.AquariumRepositoryImpl
import com.tmpsolutions.domain.model.Aquarium
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.domain.repository.AquariumRepository
import com.tmpsolutions.domain.usecase.GetAllAquariumsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(
    val getAllAquariumsUseCase: GetAllAquariumsUseCase,
    val repository: AquariumRepository
) : ViewModel() {
    private var _state = MutableSharedFlow<AquariumListState>(replay = 1)
    val state: SharedFlow<AquariumListState> = _state

    init {
        getAllAquariums()
    }

    private fun getAllAquariums() {
        viewModelScope.launch {
            getAllAquariumsUseCase()
                .flowOn(Dispatchers.Main)
                .onStart {
                    _state.emit(AquariumListState.Loading)
                }
                .collect { aquariumsList ->
                    _state.emit(AquariumListState.Success(aquariumsList))
                }
        }
    }

    fun saveNewAquarium(aquarium: AquariumDomain) = viewModelScope.launch {
        repository.insertAquarium(aquarium)
    }

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            val repository = AquariumRepositoryImpl(context.db.AquariumDao())
            return MainViewModel(
                GetAllAquariumsUseCase(repository),
                repository
            ) as T
        }
    }
}
