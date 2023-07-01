package com.example.endeavoringorms.persistence.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.endeavoringorms.persistence.room.polymorphism.CommentEntity
import com.example.endeavoringorms.persistence.room.polymorphism.LinkEntity
import com.example.endeavoringorms.persistence.room.polymorphism.Note

@Dao
interface PolymorphismDao {

    @Query("SELECT * FROM comments")
    fun allComments(): List<CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllComments(comments: List<CommentEntity>)

    @Query("SELECT * FROM links")
    fun allLinks(): List<LinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLinks(links: List<LinkEntity>)

    @Transaction
    fun allNotes() = allComments() + allLinks()

    @Transaction
    fun insert(notes: List<Note>) {
        insertAllComments(notes.filterIsInstance(CommentEntity::class.java))
        insertAllLinks(notes.filterIsInstance(LinkEntity::class.java))
    }

}