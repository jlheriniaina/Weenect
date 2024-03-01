package com.weenect.testweenect.framework.di.module

import android.content.Context
import com.weenect.testweenect.WeenectApp
import com.weenect.testweenect.framework.data.remote.service.RemoteApiService
import com.weenect.testweenect.framework.data.remote.service.RemoteApiServiceImpl
import com.weenect.testweenect.application.domaine.repositories.UserRepository
import com.weenect.testweenect.application.domaine.repositories.UserRepositoryImpl
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import com.weenect.testweenect.application.presentation.navigation.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // Fournit une instance de l'application Weenect
    @Provides
    @Singleton
    fun provideApplicationInstance(@ApplicationContext context: Context): WeenectApp {
        return context as WeenectApp
    }
    // Fournit une instance de l'implémentation de AppNavigator
    @Provides
    @Singleton
    fun providesAppNavigator(impl: AppNavigatorImpl): AppNavigator = impl

    // Fournit une instance de l'implémentation de RemoteApiService
    @Provides
    @Singleton
    fun provideRemoteApiService(impl : RemoteApiServiceImpl): RemoteApiService = impl

    // Fournit une instance de l'implémentation de UserRepository
    @Provides
    @Singleton
    fun provideUserRepository(impl : UserRepositoryImpl): UserRepository = impl

}