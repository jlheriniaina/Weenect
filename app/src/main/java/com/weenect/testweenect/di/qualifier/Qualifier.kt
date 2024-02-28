package com.weenect.testweenect.di.qualifier

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class HttpClient

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class Api

@Qualifier
@Retention
annotation class DbName