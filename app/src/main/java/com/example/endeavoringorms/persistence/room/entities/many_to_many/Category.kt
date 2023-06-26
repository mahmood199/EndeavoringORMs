package com.example.endeavoringorms.persistence.room.entities.many_to_many

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoriesManyToMany")
data class Category(
    @PrimaryKey
    val shortCode: String,
    val displayName: String
)