package com.weenect.testweenect.application.domaine.useCase.base

interface BaseUseCase<In, Out> {
    suspend fun execute(input: In): Out
}