package com.weenect.testweenect.application.presentation.ui.screen.details.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.weenect.testweenect.application.presentation.ui.screen.details.DetailsScreen
import com.weenect.testweenect.application.presentation.ui.screen.details.contractor.DetailsActions
import com.weenect.testweenect.application.presentation.ui.screen.details.coordinator.DetailsCoordinator
import com.weenect.testweenect.application.presentation.ui.screen.details.coordinator.rememberDetailsCoordinator
import com.weenect.testweenect.helpers.StatusBarColor

/**
 * Compose la route des détails de l'utilisateur.
 *
 * @param coordinator Le coordinateur des détails de l'utilisateur.
 */
@Composable
fun DetailsRoute(coordinator: DetailsCoordinator = rememberDetailsCoordinator()){

    // Collecte de l'état des détails de l'utilisateur depuis le coordinateur
    val uiState by coordinator.stateFlow.collectAsState()

    // Instance des actions associées aux détails de l'utilisateur en fonction du coordinateur
    val actions = rememberDetailsActions(coordinator = coordinator)

    // Composition de l'écran des détails de l'utilisateur avec l'état et les actions
    DetailsScreen(state = uiState, actions = actions)
}


/**
 * Retient les actions associées aux détails de l'utilisateur en fonction du coordinateur.
 *
 * @param coordinator Le coordinateur des détails de l'utilisateur.
 * @return Les actions associées aux détails de l'utilisateur.
 */
@Composable
fun rememberDetailsActions(coordinator: DetailsCoordinator) : DetailsActions {
    return remember(coordinator){
            DetailsActions(onBack = coordinator::onBackPressed)
    }
}