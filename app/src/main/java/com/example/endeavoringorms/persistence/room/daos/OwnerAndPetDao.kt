package com.example.endeavoringorms.persistence.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.endeavoringorms.persistence.room.entities.one_to_many.Owner
import com.example.endeavoringorms.persistence.room.entities.one_to_many.OwnerWithPets
import com.example.endeavoringorms.persistence.room.entities.one_to_many.Pet

@Dao
interface OwnerAndPetDao {

    @Query("SELECT * FROM owner")
    suspend fun getAllOwners(): List<Owner>

    @Query("SELECT * FROM owner where ownerId=:ownerId")
    suspend fun getOwnerById(ownerId: Long): Owner

    @Query("SELECT * FROM owner where ownerId IN (:ids)")
    suspend fun getOwnersByIds(ids: List<String>): List<Owner>

    @Query("DELETE FROM owner")
    suspend fun deleteAllOwners()

    @Query("DELETE FROM owner WHERE ownerId=:ownerId")
    suspend fun deleteOwnerById(ownerId: Long): Int


    @Query("SELECT * FROM pet")
    suspend fun getAllPets(): List<Pet>

    @Query("SELECT * FROM pet where petId=:petId")
    suspend fun getPetById(petId: Long): Pet

    @Query("SELECT * FROM pet where petId IN (:ids)")
    suspend fun getPetsByIds(ids: List<String>): List<Pet>

    @Query("DELETE FROM pet")
    suspend fun deleteAllPets()

    @Query("DELETE FROM owner WHERE ownerId=:petId")
    suspend fun deletePetById(petId: Long): Int

    @Transaction
    @Query("SELECT * from owner")
    suspend fun getAllOwnerWithPets(): List<OwnerWithPets>

    @Transaction
    @Query("SELECT * FROM owner WHERE ownerId=:ownerId")
    suspend fun getPetsWithOwnerId(ownerId: Long): OwnerWithPets


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