package com.example.profiles.di

import GetAllProfilesUseCase
import GetAllProfilesUseCaseImpl
import ProfileMapperImpl
import ProfilesMapper
import com.example.commons.NetworkModule
import com.example.core_profiles.data.ProfileApiService
import com.example.core_profiles.data.ProfilesRemoteDataSource
import com.example.core_profiles.domain.ProfilesRepository
import com.example.profiles.BuildConfig
import com.example.profiles_domain.repository.ProfilesRepositoryImpl
import com.example.profiles_remote.data.ProfileRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object ProfilesModule {

    @[Provides Singleton]
    fun provideProfileUseCase(
        repository: ProfilesRepository
    ): GetAllProfilesUseCase = GetAllProfilesUseCaseImpl(repository = repository)

    @[Provides Singleton]
    fun provideProfileRepository(
        remoteDataSource: ProfilesRemoteDataSource
    ): ProfilesRepository = ProfilesRepositoryImpl(remoteDataSource = remoteDataSource)

    @[Provides Singleton]
    fun provideProfileMapper(
    ): ProfilesMapper = ProfileMapperImpl()

    @[Provides Singleton]
    fun provideCharacterApiService(): ProfileApiService = NetworkModule.retrofitClient(
        serviceClass = ProfileApiService::class.java,
        baseUrl = BuildConfig.BASE_URL,
        converterFactory = MoshiConverterFactory.create()
    )

    @[Provides Singleton]
    fun provideProfilesDataSource(profileApiService: ProfileApiService, profileMapper: ProfilesMapper): ProfilesRemoteDataSource {
        return ProfileRemoteDataSourceImpl(
            profileApiService = profileApiService,
            profileMapper = profileMapper
        );
    }

}