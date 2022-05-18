package com.example.core_profiles.data

import MyResult
import com.example.core_profiles.models.Item
import kotlinx.coroutines.flow.Flow

interface ProfilesRemoteDataSource {

    suspend fun getAllProfiles(query: String, page: Int): Flow<MyResult<List<Item>>>

}