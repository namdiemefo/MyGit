package com.example.core_profiles.models

data class ProfilesModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)