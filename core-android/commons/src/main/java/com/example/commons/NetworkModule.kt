package com.example.commons

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    private val singleClient: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
            callTimeout(15, TimeUnit.SECONDS)
            connectTimeout(15, TimeUnit.SECONDS)
            readTimeout(15, TimeUnit.SECONDS)
            writeTimeout(15, TimeUnit.SECONDS)
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )


            if (BuildConfig.DEBUG) {
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }
        }.build()
    }

    /**
     * Uses [Retrofit] to create an instance of the supplied [serviceClass]
     */
    fun <T : Any> retrofitClient(
        serviceClass: Class<T>,
        baseUrl: String,
        client: dagger.Lazy<OkHttpClient> = dagger.Lazy { singleClient },
        converterFactory: Converter.Factory = MoshiConverterFactory.create()
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .callFactory { request -> client.get().newCall(request) }
            .build()
            .create(serviceClass)
    }
}