package com.example.endeavoringorms.persistence.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pet", foreignKeys = [ForeignKey(
        entity = Owner::class,
        parentColumns = ["ownerId"],
        childColumns = ["petId"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )],
    ignoredColumns = []
)
data class Pet(
    @PrimaryKey(autoGenerate = true)
    val petId: Long = 0L,
    @ColumnInfo(name = "pet_name")
    val petName: String,
)