package com.kapri.hiltapplication.data.repository

import com.kapri.hiltapplication.data.db.dao.CountryDao
import com.kapri.hiltapplication.data.db.model.Country
import com.kapri.hiltapplication.network.CountryService
import com.skydoves.sandwich.DataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepo @Inject constructor(
    private val dao: CountryDao,
    private val service: CountryService
) {

    suspend fun insertCountry(data: Country) = dao.insertCountry(data)

    suspend fun getAllCountries(): List<Country> = service.fetchCountryList()

    suspend fun deleteCountry(data: Country) = dao.deleteCountry(data)
}