package com.example.endeavoringorms.persistence.room.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.endeavoringorms.persistence.room.entities.Owner
import com.example.endeavoringorms.persistence.room.entities.OwnerWithPets
import com.example.endeavoringorms.persistence.room.entities.Pet

interface OwnerAndPetDao {

    @Query("SELECT * FROM owner")
    suspend fun getAllOwners(): List<Owner>

    @Query("SELECT * FROM owner where ownerId=:ownerId")
    suspend fun getOwnerById(ownerId: Long): Owner

    @Query("SELECT * FROM owner where ownerId IN (:ids)")
    suspend fun getOwnersByIds(ids: List<String>): Owner

    @Query("DELETE FROM owner")
    suspend fun deleteAllOwners()

    @Query("DELETE FROM owner WHERE ownerId=:ownerId")
    suspend fun deleteOwnerById(ownerId: Long): Owner


    @Query("SELECT * FROM pet")
    suspend fun getAllPets(): List<Pet>

    @Query("SELECT * FROM pet where petId=:petId")
    suspend fun getPetById(petId: Long): Pet

    @Query("SELECT * FROM pet where petId IN (:ids)")
    suspend fun getPetsByIds(ids: List<String>): Owner

    @Query("DELETE FROM pet")
    suspend fun deleteAllPets()

    @Query("DELETE FROM owner WHERE ownerId=:petId")
    suspend fun deletePetById(petId: Long): Pet

    @Query("SELECT * from owner")
    suspend fun getAllOwnerWithPets(): List<OwnerWithPets>


    suspend fun insertOwner(owner: Owner): Owner {
        owner.ownerId = _insertOwner(owner)
        return owner
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun _insertOwner(owner: Owner): Long


    @Insert
    suspend fun _insertPet(pet: Pet)

    @Transaction
    suspend fun insert(owner: Owner, pet: Pet) {
        _insertOwner(owner = owner)
        _insertPet(pet = pet)
    }


}