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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.weenect.testweenect.R
import com.weenect.testweenect.application.presentation.ui.components.NavHost
import com.weenect.testweenect.application.presentation.ui.components.composable
import com.weenect.testweenect.application.presentation.ui.screen.details.route.DetailsRoute
import com.weenect.testweenect.application.presentation.ui.screen.users.route.UserRoute
import com.weenect.testweenect.application.presentation.ui.theme.TestWeenectTheme
import com.weenect.testweenect.helpers.Destination
import com.weenect.testweenect.helpers.NavigationIntent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Activité principale de l'application.
 * Cette classe est annotée avec [@AndroidEntryPoint] pour permettre l'injection de dépendances avec Hilt.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (savedInstanceState == null) {
           installSplashScreen()
        } else {
            setTheme(R.style.Theme_TestWeenect)
        }
        setContent {
           MainScreen(viewModel = viewModel)
        }
    }
}

/**
 * Fonction composable représentant l'écran principal de l'application.
 *
 * @param viewModel Le ViewModel principal utilisé pour gérer la logique de l'écran.
 */
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
                composable(destination = Destination.DetailsUserScreen){
                    DetailsRoute()
                }
            }
        }
    }
}

/**
 * Fonction composable responsable de gérer les effets de navigation de l'application.
 *
 * @param navigationChannel Le canal utilisé pour recevoir les intentions de navigation.
 * @param navHostController Le contrôleur de navigation de l'application.
 */
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

