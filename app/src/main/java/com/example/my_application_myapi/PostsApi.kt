package com.example.my_application_myapi

interface PostsApi {
    suspend fun getPosts(): PostJsonMy?

}