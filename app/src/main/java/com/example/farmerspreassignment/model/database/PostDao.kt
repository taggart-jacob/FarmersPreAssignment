package com.example.farmerspreassignment.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.farmerspreassignment.model.pojo.Post

@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val allPosts: List<Post>
    val onePost: Post

    @Insert
    fun insertAll(vararg posts: Post)
}