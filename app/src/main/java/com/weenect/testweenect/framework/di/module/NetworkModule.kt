package com.weenect.testweenect.framework.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.weenect.testweenect.framework.data.remote.api.RemoteApi
import com.weenect.testweenect.framework.data.remote.models.ApiEndpoint
import com.weenect.testweenect.framework.di.qualifier.Api
import com.weenect.testweenect.framework.di.qualifier.HttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val NETWORK_TIMEOUT = 60L

    // Fournit une instance de Gson
    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("yyyy-MM-dd")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient()
        return gsonBuilder.create()
    }

    // Fournit une instance de l'interface RemoteApi annotée avec @Api
    @Provides
    @Singleton
    @Api
    internal fun provideRemote(
        @HttpClient client: OkHttpClient, gson : Gson
    ): RemoteApi {

        return Retrofit.Builder()
            .client(client)
            .baseUrl(ApiEndpoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RemoteApi::class.java)
    }
    // Fournit une instance d'OkHttpClient annotée avec @HttpClient
    @Provides
    @Singleton
    @HttpClient
    internal fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

}