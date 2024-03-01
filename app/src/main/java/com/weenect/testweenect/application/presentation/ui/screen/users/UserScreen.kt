package com.weenect.testweenect.application.presentation.ui.screen.users

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.weenect.testweenect.R
import com.weenect.testweenect.application.presentation.ui.components.EmptyContent
import com.weenect.testweenect.application.presentation.ui.components.LoadingContent
import com.weenect.testweenect.application.presentation.ui.screen.users.components.UserContent
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserActions
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserState
import com.weenect.testweenect.application.presentation.ui.theme.Primary
import com.weenect.testweenect.application.presentation.ui.theme.PrimaryDark
import com.weenect.testweenect.helpers.StatusBarColor


/**
 * Compose l'écran principal de la liste des utilisateurs.
 *
 * @param state // L'état actuel de l'écran des utilisateurs.
 * @param netState // L'état de la connexion Internet.
 * @param actions // Les actions à effectuer dans l'écran des utilisateurs.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(state : UserState,netState : Boolean, actions: UserActions){
    StatusBarColor(color = PrimaryDark)
    Scaffold(
        topBar = {
           TopAppBar(
                modifier = Modifier.wrapContentSize(),
                title = {
                    Text(text = stringResource(id = R.string.txt_title))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        content = { contentPadding ->
            when(state){
                is UserState.Idle, UserState.Loading -> LoadingContent(
                    modifier = Modifier.padding(
                        contentPadding
                    )
                )
                is UserState.Success -> UserContent(
                    modifier = Modifier.padding(contentPadding),
                    users = state.users,
                    netSate = netState,
                    actions = actions
                )
                is UserState.Empty -> EmptyContent(
                    modifier = Modifier.padding(
                         contentPadding)
                )
            }
        }
    )

}

/**
 * Compose l'aperçu de l'écran des utilisateurs pour l'aperçu Jetpack Compose.
 *
 */
@Composable
@Preview(name = "UserScreen")
private fun UserScreenPreview() {
    UserScreen(
        state = UserState.Idle,
        netState = false,
        actions = UserActions(onSelectedItem = {

        }, onLoadMoreItem = {

        }, onNetworkActive = {

        })
    )
}