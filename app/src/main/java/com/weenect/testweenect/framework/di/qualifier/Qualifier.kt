package com.weenect.testweenect.framework.di.qualifier

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class HttpClient

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class Api
