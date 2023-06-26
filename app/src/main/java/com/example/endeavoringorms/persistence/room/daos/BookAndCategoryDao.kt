package com.example.endeavoringorms.persistence.room.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.endeavoringorms.persistence.room.entities.many_to_many.CategoryAndBooks

/**
 *  The @Transaction annotations are there because we will wind up with multiple
 *  queries to populate our CategoryAndBooks objects, and Room will not automatically
 *  set up a database transaction for us to ensure that those queries all work off of the
 *  same edition of the data.
 */

@Dao
interface BookAndCategoryDao {

    @Transaction
    @Query("SELECT * FROM categoriesManyToMany")
    suspend fun loadAll(): List<CategoryAndBooks>

    @Transaction
    @Query("SELECT * FROM categoriesManyToMany WHERE shortCode = :shortCode")
    suspend fun loadByShortCode(shortCode: String): CategoryAndBooks

}