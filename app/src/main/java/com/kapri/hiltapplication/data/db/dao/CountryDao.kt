package com.kapri.hiltapplication.data.db.dao

import androidx.room.*
import com.kapri.hiltapplication.data.db.model.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Query("SELECT * FROM tblCountry")
    fun getAllCountries(): Flow<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(data: Country)

    @Delete
    suspend fun deleteCountry(data: Country)
}