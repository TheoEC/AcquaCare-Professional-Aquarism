package com.tmpsolutions.data.di

import android.content.Context
import com.tmpsolutions.data.AquariumDao
import com.tmpsolutions.data.db
import com.tmpsolutions.data.repository.ParametersRepositoryImpl
import com.tmpsolutions.domain.repository.ParametersRepository
import com.tmpsolutions.domain.usecase.parameters.GetAquariumParametersUseCase
import com.tmpsolutions.ui.aquariumParameters.ParametersViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<AquariumDao> {
        androidContext().db.AquariumDao()
    }
    single<ParametersRepository> {
        ParametersRepositoryImpl(dao = get())
    }
    single<GetAquariumParametersUseCase>{
        GetAquariumParametersUseCase(repository = get())
    }
    viewModel { (id: Int) ->
        val repository : ParametersRepository = get()
        ParametersViewModel(
            aquariumID = id,
            getAquariumParametersUseCase = get()
        )
    }
}