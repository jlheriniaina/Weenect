package com.weenect.testweenect.application.presentation.ui.screen.details.contractor

import com.weenect.testweenect.application.domaine.entities.User


/**
 * Représente l'état de l'écran des détails de l'utilisateur.
 */
sealed class DetailsState {
    /** L'état de chargement des détails de l'utilisateur. */
    data object Loading : DetailsState()

    /** L'état de succès avec les détails de l'utilisateur. */
    data class Success(val data : User) : DetailsState()

    /** L'état d'erreur avec un message d'erreur. */
    data class Error(val message : Int) : DetailsState()
}

/**
 * Actions à effectuer dans l'écran des détails de l'utilisateur.
 *
 * @param onBack Action à exécuter lorsqu'un retour en arrière est demandé.
 */
data class DetailsActions(
    val onBack : () -> Unit
)