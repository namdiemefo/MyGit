package com.example.profiles_remote.data

import MyResult

import ProfilesMapper
import com.example.commons.ApplicationError
import com.example.core_profiles.data.ProfileApiService
import com.example.core_profiles.data.ProfilesRemoteDataSource
import com.example.core_profiles.models.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileRemoteDataSourceImpl
@Inject
constructor(private val profileMapper: ProfilesMapper, private val profileApiService: ProfileApiService): ProfilesRemoteDataSource {

    override suspend fun getAllProfiles(query: String, page: Int): Flow<MyResult<List<Item>>> = flow {

        try {
            val networkRequest = profileApiService.getAllProfiles(query, page)
            if (networkRequest.isSuccessful) {
                val networkResponse = networkRequest.body()
                val profiles = profileMapper.mapToDomainList(networkResponse?.items)
                emit(
                    MyResult.data(
                        data = profiles
                    )
                )
            } else {
                emit(
                    MyResult.error(
                        ApplicationError.NetworkError(
                        errorCode = networkRequest.code(),
                            errorMessage = "Network Error occurred."
                        )
                    )
                )
            }
        } catch (e: Exception) {
            emit(
                MyResult.error(
                    ApplicationError.NetworkError(
                        errorMessage = "Network Error occurred.",
                        errorException = e
                    )
                )
            )
        }

    }.flowOn(Dispatchers.IO)


}

