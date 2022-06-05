package com.example.proyectofinal2022.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS WHERE uuid=:uuid")
    fun getUserByUuid(uuid: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)

    @Query("SELECT * FROM $TABLE_USERS")
    fun getUserFromDatabase(): List<UserEntity>

    @Delete
    fun delete(user: UserEntity)
}