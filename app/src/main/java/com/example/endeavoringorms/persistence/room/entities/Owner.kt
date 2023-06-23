package com.example.endeavoringorms.persistence.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "owner",
    /*
        primaryKeys = ["ownerId", "age"]
    */
    ignoredColumns = []
)
data class Owner(
    @PrimaryKey(autoGenerate = true)
    var ownerId: Long = 0L,
    @ColumnInfo(defaultValue = "Invalid User")
    val name: String,
    @ColumnInfo(defaultValue = "0")
    val age: Int,
)