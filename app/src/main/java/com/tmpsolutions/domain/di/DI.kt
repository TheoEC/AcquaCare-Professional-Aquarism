package com.tmpsolutions.domain.di

import com.tmpsolutions.data.db
import com.tmpsolutions.data.repository.AquariumRepositoryImpl
import com.tmpsolutions.domain.repository.AquariumRepository
import com.tmpsolutions.domain.usecase.GetAquariumUseCase
import com.tmpsolutions.ui.aquariumDetails.AquariumDetailViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val aquariumModule = module {
    single<AquariumRepository> {
        AquariumRepositoryImpl(
            dao = androidContext().db.AquariumDao()
        )
    }

    single<GetAquariumUseCase> {
        GetAquariumUseCase(repository = get())
    }

    viewModel{ (id : Int) ->
        AquariumDetailViewModel(
            aquariumID = id,
            getAquariumUseCase = get()
        )
    }
}