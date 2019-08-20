package com.example.farmerspreassignment.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.farmerspreassignment.model.pojo.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}