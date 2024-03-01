package com.weenect.testweenect.application.presentation.ui.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weenect.testweenect.application.domaine.useCase.users.GetUserUseCase
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import com.weenect.testweenect.application.presentation.ui.screen.details.contractor.DetailsState
import com.weenect.testweenect.helpers.KEY_USER_ID
import com.weenect.testweenect.helpers.NavigationConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * ViewModel responsable de la logique métier associée aux détails d'un utilisateur.
 * Cette classe est annotée avec @HiltViewModel pour être injectée via Hilt.
 *
 * @property appNavigator Le navigateur d'application utilisé pour gérer la navigation.
 * @property userUseCase Le cas d'utilisation pour récupérer les détails d'un utilisateur.
 * @property savedStateHandle Le gestionnaire de l'état sauvegardé pour récupérer l'ID de l'utilisateur.
 */
@HiltViewModel
class DetailsViewModel
@Inject
constructor(private val appNavigator: AppNavigator,
            savedStateHandle: SavedStateHandle,
            private val userUseCase: GetUserUseCase) : ViewModel()  {
    // DataFlow mutable de l'état des détails de l'utilisateur
    private val _stateFlow = MutableStateFlow<DetailsState>(DetailsState.Loading)
    // DataFlow d'état exposé en lecture seule
    val stateFlow = _stateFlow.asStateFlow()

    // ID de l'utilisateur récupéré à partir de l'état sauvegardé
    private val userId = savedStateHandle[KEY_USER_ID] ?: ""

    // Initialisation, récupération des détails de l'utilisateur
    init {
        this.getUser()
    }

    // Récupération des détails de l'utilisateur à partir du cas d'utilisation
    private fun getUser(){
        viewModelScope.launch {
            val user = userUseCase.execute(input = userId)
            _stateFlow.value = DetailsState.Success(user)
        }
    }

    // Navigation arrière vers l'écran des utilisateurs
    fun navigationBack(){
        viewModelScope.launch {
            appNavigator.navigateBack(NavigationConstant.USER_SCREEN)
        }
    }

}