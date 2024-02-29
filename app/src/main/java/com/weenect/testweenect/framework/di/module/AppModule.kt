package com.weenect.testweenect.framework.di.module

import android.content.Context
import com.weenect.testweenect.WeenectApp
import com.weenect.testweenect.framework.data.remote.service.RemoteApiService
import com.weenect.testweenect.framework.data.remote.service.RemoteApiServiceImpl
import com.weenect.testweenect.application.domaine.interactor.UserUseCase
import com.weenect.testweenect.application.domaine.interactor.UserUseCaseImpl
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

    @Provides
    @Singleton
    fun provideApplicationInstance(@ApplicationContext context: Context): WeenectApp {
        return context as WeenectApp
    }

    @Provides
    @Singleton
    fun providesAppNavigator(impl: AppNavigatorImpl): AppNavigator = impl
    @Provides
    @Singleton
    fun provideRemoteApiService(impl : RemoteApiServiceImpl): RemoteApiService = impl

    @Provides
    @Singleton
    fun provideUserRepository(impl : UserRepositoryImpl): UserRepository = impl

    @Provides
    @Singleton
    fun provideUserUseCase(impl : UserUseCaseImpl): UserUseCase = impl
}