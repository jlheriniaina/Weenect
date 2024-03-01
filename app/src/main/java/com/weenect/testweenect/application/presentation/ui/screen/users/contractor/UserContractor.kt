package com.weenect.testweenect.application.presentation.ui.screen.users.contractor

import com.weenect.testweenect.application.domaine.entities.User


/**
 * Représente l'état de l'écran des utilisateurs.
 */
sealed class UserState {
    /** L'état lorsqu'il n'y a pas encore d'action ou de chargement. */
    data object Idle : UserState()

    /** L'état de chargement des données. */
    data object Loading : UserState()

    /** L'état de succès avec une liste d'utilisateurs. */
    data class Success(val users : List<User>)  : UserState()

    /** L'état lorsque la liste des utilisateurs est vide. */
    data  object Empty : UserState()
}


/**
 * Actions à effectuer dans l'écran des utilisateurs.
 *
 * @param onSelectedItem // Action à exécuter lorsqu'un élément utilisateur est sélectionné.
 * @param onNetworkActive // Action à exécuter lorsque la connexion réseau est active.
 * @param onLoadMoreItem // Action à exécuter pour charger plus d'éléments (utilisateurs).
 */
data class UserActions(
    val onSelectedItem : (User) -> Unit,
    val onNetworkActive : () -> Unit,
    val onLoadMoreItem : () -> Unit
)