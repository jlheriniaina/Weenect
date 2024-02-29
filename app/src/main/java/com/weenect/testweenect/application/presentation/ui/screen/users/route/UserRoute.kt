package com.weenect.testweenect.application.presentation.ui.screen.users.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.weenect.testweenect.application.presentation.ui.screen.users.UserScreen
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserActions
import com.weenect.testweenect.application.presentation.ui.screen.users.coordinator.UserCoordinator
import com.weenect.testweenect.application.presentation.ui.screen.users.coordinator.rememberHomeCoordinator

@Composable
fun UserRoute(
    coordinator: UserCoordinator = rememberHomeCoordinator()
) {
   // State observing and declarations
   val uiState by coordinator.stateFlow.collectAsState()

   //UI Actions
   val actions = rememberUserActions(coordinator = coordinator)

   //UI Rendering
   UserScreen(state = uiState, actions = actions)

}
@Composable
fun rememberUserActions(coordinator: UserCoordinator) : UserActions  {
    return remember(coordinator){
            UserActions(onSelectedItem = coordinator::onDetail)
    }
}