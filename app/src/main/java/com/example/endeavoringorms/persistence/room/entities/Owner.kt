package com.example.endeavoringorms.persistence.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "owner")
data class Owner(
    @PrimaryKey(autoGenerate = true)
    val ownerId: Long = 0L,
    val name: String,
    val age: Int,
)