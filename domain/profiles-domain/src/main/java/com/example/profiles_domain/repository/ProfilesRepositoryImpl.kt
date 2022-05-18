package com.example.profiles_domain.repository

import DomainResult
import com.example.commons.ApplicationError
import com.example.core_profiles.data.ProfilesRemoteDataSource
import com.example.core_profiles.domain.ProfilesRepository
import com.example.core_profiles.models.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfilesRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: ProfilesRemoteDataSource
) : ProfilesRepository {
    override suspend fun getAllProfiles(query: String, page: Int): Flow<DomainResult<List<Item>>> = flow {

        remoteDataSource.getAllProfiles(query, page).collect {  result ->
            result.data?.let { profiles ->
                emit(
                    DomainResult.Success<List<Item>>(
                        data = profiles
                    )
                )
            }

            result.error.let { error ->
                if (error != ApplicationError.NoError) {
                    emit(
                        DomainResult.Error<List<Item>>(
                            error = error
                        )
                    )
                }
            }

        }
    }

}