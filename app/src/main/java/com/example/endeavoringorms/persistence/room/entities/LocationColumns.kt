package com.example.endeavoringorms.persistence.room.entities

import android.location.Location
import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

data class LocationColumns(
    val latitude: Double,
    val longitude: Double
) {
    constructor(loc: Location) : this(loc.latitude, loc.longitude)
}


/**
 *  CREATE TABLE IF NOT EXISTS embedded (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 *  name TEXT NOT NULL, latitude REAL NOT NULL, longitude REAL NOT NULL)
 */
@Entity(tableName = "embedded")
data class EmbeddedLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    @Embedded("demo_prefix_")
    val location: LocationColumns
) {
    @Dao
    interface Store {
        @Query("SELECT * FROM embedded")
        fun loadAll(): List<EmbeddedLocationEntity>

        @Query("SELECT * FROM embedded WHERE demo_prefix_longitude=:longitude AND demo_prefix_latitude=:latitude")
        fun loadAllSelectively(longitude: Double, latitude: Double): List<EmbeddedLocationEntity>


        @Insert
        fun insert(entity: EmbeddedLocationEntity)
    }
}
