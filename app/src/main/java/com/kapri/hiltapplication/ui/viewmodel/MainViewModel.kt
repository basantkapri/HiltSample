package com.kapri.hiltapplication.ui.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kapri.hiltapplication.data.db.model.Country
import com.kapri.hiltapplication.data.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: CountryRepo,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    suspend fun getAllCountries(): List<Country> = repository.getAllCountries()

    fun insertCountry(name: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            repository.insertCountry(
                Country(name, name, name, name, 100, name)
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}