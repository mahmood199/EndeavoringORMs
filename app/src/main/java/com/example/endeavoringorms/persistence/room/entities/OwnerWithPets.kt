package com.example.endeavoringorms.persistence.room.entities

import androidx.room.Embedded
import androidx.room.Relation

data class OwnerWithPets(
    @Embedded val owner: Owner,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "petId"
    )
    val pets: List<Pet>,
)