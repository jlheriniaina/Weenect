package com.weenect.testweenect.application.presentation.ui.screen.users.contractor

import com.weenect.testweenect.application.domaine.entities.User


sealed class UserState {
    data object Idle : UserState()
    data object Loading : UserState()
    data class Success(val users : List<User>)  : UserState()

    data  object Empty : UserState()
}

data class UserActions(
    val onSelectedItem : (User) -> Unit
)