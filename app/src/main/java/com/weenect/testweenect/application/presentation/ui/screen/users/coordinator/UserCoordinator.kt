package com.weenect.testweenect.application.presentation.ui.screen.users.coordinator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.presentation.ui.screen.users.UserViewModel

class UserCoordinator(val viewModel: UserViewModel) {
    val stateFlow = viewModel.stateFlow
    fun onDetail(user : User){

    }
}
@Composable
fun rememberHomeCoordinator(viewModel: UserViewModel = hiltViewModel()) : UserCoordinator {
    return remember(viewModel) {
        UserCoordinator(
            viewModel = viewModel
        )
    }
}