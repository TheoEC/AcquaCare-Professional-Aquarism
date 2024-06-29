package com.tmpsolutions.data.di

import android.content.Context
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tmpsolutions.data.db
import com.tmpsolutions.data.repository.ParametersRepositoryImpl
import com.tmpsolutions.domain.repository.ParametersRepository
import com.tmpsolutions.ui.aquariumParameters.ParametersViewModel
import org.koin.dsl.module

val koinModule = module {
    single<ParametersRepository> {
        val context : Context = get()
        ParametersRepositoryImpl(context.db.AquariumDao())
    }
//    viewModel {
//        ParametersViewModel(1)
//    }
}