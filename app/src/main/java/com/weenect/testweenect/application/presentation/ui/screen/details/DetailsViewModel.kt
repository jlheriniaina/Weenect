package com.weenect.testweenect.application.presentation.ui.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.weenect.testweenect.application.domaine.interactor.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject
constructor(savedStateHandle: SavedStateHandle,
            private val userUseCase: UserUseCase) : ViewModel()  {

}