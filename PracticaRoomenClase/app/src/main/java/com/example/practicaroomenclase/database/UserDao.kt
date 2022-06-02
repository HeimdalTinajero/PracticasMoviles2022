package com.example.practicaroomenclase.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUserFromDatabase(): List<UserEntity>

    @Query("SELECT * FROM $TABLE_USERS WHERE uuid=:uuid")
    fun getUserByUuid(uuid: String): UserEntity

    @Delete
    fun delete(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)
}