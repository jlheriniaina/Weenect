package com.weenect.testweenect.application.presentation.ui.screen.users.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.weenect.testweenect.application.presentation.ui.screen.users.UserScreen
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserActions
import com.weenect.testweenect.application.presentation.ui.screen.users.coordinator.UserCoordinator
import com.weenect.testweenect.application.presentation.ui.screen.users.coordinator.rememberHomeCoordinator


/**
 * Compose la route de l'écran d'accueil des utilisateurs.
 *
 * @param coordinator Le coordinateur de l'écran d'accueil des utilisateurs.
 */
@Composable
fun UserRoute(
    coordinator: UserCoordinator = rememberHomeCoordinator()
) {
    // Récupération de l'état et de l'état du de données depuis le coordinateur
    val uiState by coordinator.stateFlow.collectAsState()
    // Récupération de l'état et de l'état du réseau depuis le coordinateur
    val uiNetworkState by coordinator.networkState.collectAsState()

   // Rappel des actions associées à l'écran d'accueil des utilisateurs en fonction du coordinateur
   val actions = rememberUserActions(coordinator = coordinator)

    // Composition de l'écran d'accueil des utilisateurs avec l'état et les actions
    UserScreen(state = uiState, netState = uiNetworkState, actions = actions)

}

/**
 * Retient les actions associées à l'écran d'accueil des utilisateurs en fonction du coordinateur.
 *
 * @param coordinator Le coordinateur de l'écran d'accueil des utilisateurs.
 * @return Les actions associées à l'écran d'accueil des utilisateurs.
 */
@Composable
fun rememberUserActions(coordinator: UserCoordinator) : UserActions  {
    return remember(coordinator){
            UserActions(onSelectedItem = coordinator::onDetail,
                        onLoadMoreItem = coordinator::onLoadItem,
                        onNetworkActive = coordinator::isAvailableNetwork)
    }
}