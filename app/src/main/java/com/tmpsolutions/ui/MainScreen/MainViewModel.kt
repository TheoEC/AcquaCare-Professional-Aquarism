package com.tmpsolutions.ui.MainScreen

import androidx.lifecycle.ViewModel
import com.tmpsolutions.domain.model.Aquarium

class MainViewModel : ViewModel() {
    var aquariums = listOf<Aquarium>()
}