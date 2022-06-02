package com.example.practicaroomenclase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name= "user_name") val name: String,
    val user_height: Double,
    val user_wight: Double,
    val user_email: String,
    val user_password: String
)


fun UserEntity.toUser() = User(
    uuid,
    name,
    user_height,
    user_wight,
    user_email,
    user_password
)