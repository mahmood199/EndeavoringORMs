package com.example.endeavoringorms.persistence.room.daos

import androidx.room.Query
import com.example.endeavoringorms.persistence.room.entities.Owner
import com.example.endeavoringorms.persistence.room.entities.OwnerWithPets
import com.example.endeavoringorms.persistence.room.entities.Pet

interface OwnerAndPetDao {

    @Query("SELECT * FROM owner")
    suspend fun getAllOwners(): List<Owner>

    @Query("SELECT * FROM pet")
    suspend fun getAllPets(): List<Pet>

    @Query("SELECT * from owner")
    suspend fun getAllOwnerWithPets(): List<OwnerWithPets>


}