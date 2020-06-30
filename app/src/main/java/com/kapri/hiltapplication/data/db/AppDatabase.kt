package com.kapri.hiltapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kapri.hiltapplication.data.db.dao.CountryDao
import com.kapri.hiltapplication.data.db.model.Country
import com.kapri.hiltapplication.utils.Constants

@Database(entities = [Country::class], version = Constants.DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCountryDao(): CountryDao
}