package com.kapri.hiltapplication.network

import com.kapri.hiltapplication.data.db.model.Country
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CountryService {
    @GET("all")
    suspend fun fetchCountryList(): List<Country>

    //@GET("all/{name}")
    //suspend fun fetchCountryList(@Path("name") name: String): DataSource<Country>
}