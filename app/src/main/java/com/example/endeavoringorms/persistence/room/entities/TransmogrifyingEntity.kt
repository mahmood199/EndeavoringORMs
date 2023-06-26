package com.example.endeavoringorms.persistence.room.entities

import android.location.Location
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.endeavoringorms.persistence.room.type_converters.TypeTransmogrifier
import java.time.Instant

@Entity(tableName = "transmogrified")
@TypeConverters(TypeTransmogrifier::class)
@RequiresApi(Build.VERSION_CODES.O)
data class TransmogrifyingEntity constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val creationTime: Instant = Instant.now(),
    val location: Location = Location(null as String?).apply {
        latitude = 0.0
        longitude = 0.0
    },
    val tags: Set<String> = setOf()
) {
    @Dao
    interface Store {
        @Query("SELECT * FROM transmogrified")
        fun loadAll(): List<TransmogrifyingEntity>

        @Insert
        fun insert(entity: TransmogrifyingEntity)
    }
}