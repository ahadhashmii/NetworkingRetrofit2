package com.ahadhashmi.networkingretrofit2.models

data class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)