package com.example.farmerspreassignment.model.database

import androidx.room.Insert
import androidx.room.Query
import com.example.farmerspreassignment.model.pojo.Comment

interface CommentDao {
    @get:Query("SELECT body FROM comment")
    val commentBody: String

    @Insert
    fun insertAll(vararg comments: Comment)
}