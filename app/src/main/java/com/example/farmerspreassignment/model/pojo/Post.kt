package com.example.farmerspreassignment.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    val body: String,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)

@Entity
data class Comment(
    val body: String,
    val email: String,
    @field:PrimaryKey
    val id: Int,
    val name: String,
    val postId: Int
)

@Entity
data class Users(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

data class Geo(
    val lat: String,
    val lng: String
)

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)

data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
)