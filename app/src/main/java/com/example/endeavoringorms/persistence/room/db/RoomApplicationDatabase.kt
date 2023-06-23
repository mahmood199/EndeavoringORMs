package com.example.endeavoringorms.persistence.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.endeavoringorms.persistence.room.entities.Owner
import com.example.endeavoringorms.persistence.room.entities.Pet


@Database(
    entities = [
        Owner::class,
        Pet::class
    ],
    version = 1
)
abstract class RoomApplicationDatabase: RoomDatabase() {




}