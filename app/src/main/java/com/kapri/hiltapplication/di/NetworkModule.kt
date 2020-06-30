package com.kapri.hiltapplication.di

import com.kapri.hiltapplication.network.CountryClient
import com.kapri.hiltapplication.network.CountryService
import com.kapri.hiltapplication.network.HttpRequestInterceptor
import com.kapri.hiltapplication.utils.Constants
import com.skydoves.sandwich.coroutines.CoroutinesDataSourceCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(HttpRequestInterceptor())
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(Constants.BASE_URL)
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(CoroutinesDataSourceCallAdapterFactory())
      .build()
  }

  @Provides
  @Singleton
  fun provideCountryService(retrofit: Retrofit): CountryService {
    return retrofit.create(CountryService::class.java)
  }

  @Provides
  @Singleton
  fun provideCountryClient(countryService: CountryService): CountryClient {
    return CountryClient(countryService)
  }
}