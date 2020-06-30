package com.kapri.hiltapplication.di

import android.content.Context
import androidx.room.Room
import com.kapri.hiltapplication.data.db.AppDatabase
import com.kapri.hiltapplication.data.db.dao.CountryDao
import com.kapri.hiltapplication.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            Constants.DB_NAME
        ).build()
    }

    @Provides
    fun provideTodoDao(database: AppDatabase): CountryDao {
        return database.getCountryDao()
    }
}