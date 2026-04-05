package com.example.cyberarmour.Auth

import java.io.Serializable

data class Scam(
    val title: String,
    val description: String,
    val severity: String
) : Serializable
