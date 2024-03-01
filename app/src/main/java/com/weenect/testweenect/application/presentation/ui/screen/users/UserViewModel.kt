package com.weenect.testweenect.application.presentation.ui.screen.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.domaine.useCase.users.GetUsersUseCase
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserState
import com.weenect.testweenect.helpers.CheckInternet
import com.weenect.testweenect.helpers.Destination
import com.weenect.testweenect.helpers.NavigationConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * ViewModel responsable de la logique métier associée à la liste des utilisateurs.
 * Cette classe est annotée avec @HiltViewModel pour être injectée via Hilt.
 *
 * @property appNavigator Le navigateur d'application utilisé pour gérer la navigation.
 * @property userUseCase Le cas d'utilisation pour récupérer la liste des utilisateurs.
 * @property checkInternet L'utilitaire de vérification de la connexion Internet.
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val userUseCase: GetUsersUseCase,
    private val checkInternet: CheckInternet
) : ViewModel() {
    // Flot mutable pour état interne
    private val _stateFlow : MutableStateFlow<UserState> = MutableStateFlow(UserState.Idle)
    // Flot état exposé en lecture seule
    val stateFlow : StateFlow<UserState> = _stateFlow.asStateFlow()
    // Flot mutable pour l'état de la connexion réseau
    private val _networkState  = MutableStateFlow(true)
    // Flot d'état de la connexion réseau exposé en lecture seule
    val networkState = _networkState.asStateFlow()
    // Numéro de page actuel pour la pagination
    private var currentPage = 0
    // Liste mutable des utilisateurs
    private val users = mutableListOf<User>()

    // Initialisation, récupération initiale des utilisateurs
    init {
        getUsers()
    }

    // Récupération des utilisateurs depuis le cas d'utilisation
    fun getUsers(){
        currentPage++
        viewModelScope.launch{
            userUseCase.execute(input = currentPage)
                .collect {
                    if (it.isNotEmpty()){
                         users.addAll(it)
                        _stateFlow.value = UserState.Success(users.toList())
                    }else {
                        _stateFlow.value = UserState.Empty
                }
            }
        }
    }


    // Vérification de l'état de la connexion Internet
    fun checkNetwork(){
        checkInternet.isCheck {
           _networkState.value = it
        }
    }

    // Ouverture des détails d'un utilisateur
    fun openDetails(user: User){
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.DetailsUserScreen(userId = user.uuid), NavigationConstant.USER_SCREEN)
        }
    }
}