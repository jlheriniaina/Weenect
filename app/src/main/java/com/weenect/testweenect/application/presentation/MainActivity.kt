package com.weenect.testweenect.application.presentation

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.weenect.testweenect.application.presentation.ui.components.NavHost
import com.weenect.testweenect.application.presentation.ui.components.composable
import com.weenect.testweenect.application.presentation.ui.screen.users.route.UserRoute
import com.weenect.testweenect.application.presentation.ui.theme.TestWeenectTheme
import com.weenect.testweenect.helpers.Destination
import com.weenect.testweenect.helpers.NavigationIntent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainScreen(viewModel = viewModel)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel){
    val navController = rememberNavController()
    NavigationEffects(
        navigationChannel = viewModel.navigationChannel,
        navHostController = navController
    )
    TestWeenectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination  = Destination.UserScreen
            )
            {
                composable(destination = Destination.UserScreen) {
                    UserRoute()
                }
            }
        }
    }
}
@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null)
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    else
                        navHostController.popBackStack()
                }
                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {

                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}

