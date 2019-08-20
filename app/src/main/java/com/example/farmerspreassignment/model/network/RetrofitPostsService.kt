package com.example.farmerspreassignment.model.network

import com.example.farmerspreassignment.model.pojo.Post
import com.example.farmerspreassignment.util.POSTS_PATH
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitPostsService {
    @GET(POSTS_PATH)
    fun getAllPosts(): Observable<List<Post>>
}