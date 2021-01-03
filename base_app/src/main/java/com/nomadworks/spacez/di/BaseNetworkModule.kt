package com.nomadworks.spacez.di

import com.nomadworks.spacez.BuildConfig
import com.nomadworks.spacez.api.SpacexService
import com.nomadworks.spacez.config.AppConfig
import com.nomadworks.spacez.resource.ResourceQuery
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class BaseNetworkModule {
    companion object {
        const val HEADER_DEVICE_ID = "device_id"
        const val HEADER_USER_AGENT = "User-Agent"
    }

    @Singleton
    @Provides
    fun provideSpacexService(retrofit: Retrofit): SpacexService {
        return retrofit.create(SpacexService::class.java)
    }

    @Provides
    fun provideRetrofit(appConfig: AppConfig, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(appConfig.baseUrl)
                .client(client)
                .build()
    }

    @Provides
    fun provideOkHttpClient(resourceQuery: ResourceQuery): OkHttpClient {
        return createOkHttpClient(resourceQuery)
    }

    private fun createOkHttpClient(resourceQuery: ResourceQuery): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor(
                createHeaderInterceptor(resourceQuery)
        )
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        return builder.build()
    }

    private fun createHeaderInterceptor(resourceQuery: ResourceQuery): Interceptor =
            Interceptor { chain: Interceptor.Chain ->
                val builder =
                        chain.request().newBuilder().header(HEADER_DEVICE_ID, resourceQuery.getDeviceId())
                builder.header(HEADER_USER_AGENT, getUserAgentValue(resourceQuery))
                val request = builder.build()
                request.run {
                    chain.proceed(request)
                }
            }

    private fun getUserAgentValue(resourceQuery: ResourceQuery): String = "spacez-android/${resourceQuery.getVersionName()}-${resourceQuery.getVersionCode()}"
}