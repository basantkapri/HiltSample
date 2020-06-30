package com.kapri.hiltapplication.utils

class Constants {
    companion object {
        const val API_RETRY_COUNT = 3
        const val API_RETRY_DELAY = 7000L

        const val DB_NAME = "todo.db"
        const val DB_VERSION = 1
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }
}