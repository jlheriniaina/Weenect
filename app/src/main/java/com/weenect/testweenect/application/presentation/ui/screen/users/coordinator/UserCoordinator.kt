package com.weenect.testweenect.application.presentation.ui.screen.users.coordinator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.presentation.ui.screen.users.UserViewModel

/**
 * Classe responsable de la coordination entre la logique métier du ViewModel et l'interface utilisateur.
 *
 * @property viewModel // Le ViewModel gérant la logique métier des utilisateurs.
 */
class UserCoordinator(val viewModel: UserViewModel) {
    // DataFlow de l'état de l'écran des utilisateurs
    val stateFlow = viewModel.stateFlow
    // DataFlow de l'état de la connexion réseau
    val networkState = viewModel.networkState

    /**
     * Ouvre les détails d'un utilisateur.
     *
     * @param user L'utilisateur dont les détails doivent être ouverts.
     */
    fun onDetail(user : User){
       viewModel.openDetails(user)
    }

    /**
     * Vérifie la disponibilité du réseau.
     */
    fun isAvailableNetwork(){
        viewModel.checkNetwork()
    }

    /**
     * Charge davantage d'éléments (utilisateurs).
     */
    fun onLoadItem(){
       viewModel.getUsers()
    }
}

/**
 * Crée et retient une instance de UserCoordinator en utilisant le ViewModel passé en paramètre.
 *
 * @param viewModel // Le ViewModel des utilisateurs, récupéré via Hilt.
 * @return  // L'instance de UserCoordinator associée au ViewModel.
 */
@Composable
fun rememberHomeCoordinator(viewModel: UserViewModel = hiltViewModel()) : UserCoordinator {
    return remember(viewModel) {
        UserCoordinator(
            viewModel = viewModel
        )
    }
}