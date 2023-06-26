package com.example.endeavoringorms.persistence.room.db

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.endeavoringorms.persistence.room.daos.BookAndCategoryDao
import com.example.endeavoringorms.persistence.room.daos.OwnerAndPetDao
import com.example.endeavoringorms.persistence.room.entities.TransmogrifyingEntity
import com.example.endeavoringorms.persistence.room.entities.many_to_many.Book
import com.example.endeavoringorms.persistence.room.entities.many_to_many.BookCategoryJoin
import com.example.endeavoringorms.persistence.room.entities.many_to_many.Category
import com.example.endeavoringorms.persistence.room.entities.one_to_many.Owner
import com.example.endeavoringorms.persistence.room.entities.one_to_many.Pet


@RequiresApi(Build.VERSION_CODES.O)
@Database(
    entities = [
        Owner::class,
        Pet::class,
        Book::class,
        Category::class,
        TransmogrifyingEntity::class,
        BookCategoryJoin::class
    ],
    version = 2
)
abstract class RoomApplicationDatabase : RoomDatabase() {
    abstract fun getOwnerPetDao(): OwnerAndPetDao
    abstract fun getBookAndCategoryDao(): BookAndCategoryDao

}