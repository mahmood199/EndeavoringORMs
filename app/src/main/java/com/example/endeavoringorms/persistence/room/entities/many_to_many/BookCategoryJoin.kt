package com.example.endeavoringorms.persistence.room.entities.many_to_many

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index

/**
 *  The BookCategoryJoin class has our keys: isbn to point to a Book and shortCode to
 *  point to a Category. Hence, each BookCategoryJoin instance (or row in its table)
 *  represents one relationship between a Book and Category.
 *
 *  The @Entity annotation is more complex:
 *  • We use the primaryKeys property to say that the combination of isbn and
 *  shortCode is the primary key for our table
 *  • We set up indices on each of those columns, as we will be querying this
 *  table a lot to find all categories for a book or all books for a category
 *  • We have two @ForeignKey annotations, tying this class to Book and
 *  Category, and using onDelete = CASCADE to ensure that when we delete a
 *  Book or Category that its corresponding join entry gets deleted
 */


@Entity(
    primaryKeys = ["isbn", "shortCode"],
    indices = [Index("isbn"), Index("shortCode")],
    foreignKeys = [
        ForeignKey(
            entity = Book::class,
            parentColumns = arrayOf("isbn"),
            childColumns = arrayOf("isbn"),
            onDelete = CASCADE
        ), ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("shortCode"),
            childColumns = arrayOf("shortCode"),
            onDelete = CASCADE
        )
    ]
)
data class BookCategoryJoin(
    val isbn: String,
    val shortCode: String
)