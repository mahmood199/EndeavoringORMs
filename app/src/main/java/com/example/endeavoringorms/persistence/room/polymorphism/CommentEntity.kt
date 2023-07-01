package com.example.endeavoringorms.persistence.room.polymorphism

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class CommentEntity(
    @PrimaryKey
    val id: Long,
    val text: String
) : Note {
    override val displayText: CharSequence
        get() = text
}