package com.example.practicaroomenclase.database

class User (
    user_id:String,
    user_name:String,
    user_height: Double,
    user_wight: Double,
    user_email: String,
    user_password: String
        ) {

    val user_id: String = user_id
    val user_name: String = user_name
    val user_height: Double = user_height
    val user_wight: Double = user_wight
    val user_email: String = user_email
    val user_password: String = user_email
}
fun User.toEntity() = UserEntity(
    user_id,
    user_name,
    user_height,
    user_wight,
    user_email,
    user_password
)
