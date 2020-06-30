package com.kapri.hiltapplication.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "tblCountry")
data class Country(
    @PrimaryKey
    @field:Json(name = "name") @ColumnInfo(name = "name")
    val name: String,

    @field:Json(name = "alpha3Code") @ColumnInfo(name = "alpha3Code")
    val alpha3Code: String,

    @field:Json(name = "region") @ColumnInfo(name = "region")
    val region: String,

    @field:Json(name = "subregion") @ColumnInfo(name = "subregion")
    val subregion: String,

    @field:Json(name = "population") @ColumnInfo(name = "population")
    val population: Long,

    @field:Json(name = "flag") @ColumnInfo(name = "flag")
    val flag: String
)