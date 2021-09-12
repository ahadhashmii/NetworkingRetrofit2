package com.ahadhashmi.networkingretrofit2.network

import com.ahadhashmi.networkingretrofit2.models.Comment
import com.ahadhashmi.networkingretrofit2.models.Post
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequests {

    @GET("posts/{id}")
    suspend fun getAllPosts(@Path("id") id: String = "") : List<Post>

    @GET("comments")
    suspend fun getComments(@Query("postId") postId: Int) : List<Comment>
}