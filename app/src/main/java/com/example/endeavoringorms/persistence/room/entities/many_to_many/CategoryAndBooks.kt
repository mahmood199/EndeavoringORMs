package com.example.endeavoringorms.persistence.room.entities.many_to_many

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CategoryAndBooks(
    @Embedded
    val category: Category,
    @Relation(
        parentColumn = "shortCode",
        entityColumn = "isbn",
        associateBy = Junction(
            value = BookCategoryJoin::class,
            parentColumn = "shortCode",
            entityColumn = "isbn"
        )
    )
    val books: List<Book>
)