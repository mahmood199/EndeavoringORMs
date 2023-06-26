package com.example.endeavoringorms.persistence.room.entities.many_to_many

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booksManyToMany")
data class Book(
    @PrimaryKey
    val isbn: String,
    val title: String
)
