package com.kapri.hiltapplication.network

import com.kapri.hiltapplication.data.db.model.Country
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CountryClient @Inject constructor(private val countryService: CountryService) {
    suspend fun fetchCountryList(onResult: (response: ApiResponse<Flow<List<Country>>>) -> Unit) {
        countryService.fetchCountryList().onEach {  }
    }
}
