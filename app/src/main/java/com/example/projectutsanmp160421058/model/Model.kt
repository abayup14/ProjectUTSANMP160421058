package com.example.projectutsanmp160421058.model

data class User (
    val id: Int?,
    val username: String?,
    val nama_depan: String?,
    val nama_belakang: String?,
    val email: String?,
    val password: String?,
)

data class FootballManager (
    val id: Int?,
    val title: String?,
    val creator: String?,
    val photo_url: String?,
    val description: String?,
    val content: String?,
)