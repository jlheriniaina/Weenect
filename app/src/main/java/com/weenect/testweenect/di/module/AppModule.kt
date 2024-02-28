package com.weenect.testweenect.di.module

import android.content.Context
import com.weenect.testweenect.WeenectApp
import com.weenect.testweenect.data.remote.service.RemoteApiService
import com.weenect.testweenect.data.remote.service.RemoteApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationInstance(@ApplicationContext context: Context): WeenectApp {
        return context as WeenectApp
    }

    @Provides
    @Singleton
    fun provideRemoteApiService(impl : RemoteApiServiceImpl): RemoteApiService = impl
}