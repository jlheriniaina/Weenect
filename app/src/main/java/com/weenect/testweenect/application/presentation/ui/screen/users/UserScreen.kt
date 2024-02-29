package com.weenect.testweenect.application.presentation.ui.screen.users

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.weenect.testweenect.R
import com.weenect.testweenect.application.presentation.ui.screen.users.components.EmptyContent
import com.weenect.testweenect.application.presentation.ui.screen.users.components.LoadingContent
import com.weenect.testweenect.application.presentation.ui.screen.users.components.UserContent
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserActions
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserState
import com.weenect.testweenect.application.presentation.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(state : UserState,netState : Boolean, actions: UserActions){

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

@Composable
@Preview(name = "User")
private fun UserScreenPreview() {
    UserScreen(
        state = UserState.Idle,
        netState = false,
        actions = UserActions(onSelectedItem = {

        }, onLoadMoreItem = {

        },
            onNetworkActive = {

            })
    )
}