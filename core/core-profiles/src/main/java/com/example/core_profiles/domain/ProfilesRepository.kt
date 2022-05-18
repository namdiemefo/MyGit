package com.example.core_profiles.domain

import DomainResult
import com.example.core_profiles.data.ProfilesRemoteDataSource
import com.example.core_profiles.models.Item
import kotlinx.coroutines.flow.Flow

interface ProfilesRepository {

    suspend fun getAllProfiles(query: String, page: Int): Flow<DomainResult<List<Item>>>
}