package com.example.my_application_myapi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FollowingProduction(
    @SerialName("days_until")
    val daysUntil: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("overview")
    val overview: String,
    @SerialName("poster_url")
    val posterUrl: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String
)