package com.weenect.testweenect.application.presentation.ui.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weenect.testweenect.application.presentation.ui.screen.details.components.DetailsContent
import com.weenect.testweenect.application.presentation.ui.screen.details.contractor.DetailsActions
import com.weenect.testweenect.application.presentation.ui.screen.details.contractor.DetailsState
import com.weenect.testweenect.application.presentation.ui.components.EmptyContent
import com.weenect.testweenect.application.presentation.ui.components.LoadingContent
import com.weenect.testweenect.helpers.StatusBarColor


/**
 * Compose l'écran des détails de l'utilisateur.
 *
 * @param state // L'état actuel de l'écran des détails de l'utilisateur.
 * @param actions // Les actions à effectuer dans l'écran des détails de l'utilisateur.
 */
@Composable
fun DetailsScreen(
    state : DetailsState,
    actions : DetailsActions){

    // Configuration de la couleur de la barre de statut pour qu'elle soit transparente
    StatusBarColor(color = Color.Transparent)
    // Composition du contenu de l'écran des détails de l'utilisateur
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
        content = { contentPadding ->
               Box(
                   Modifier
                       .fillMaxSize()
                       .padding(contentPadding)){
                   // Affichage du contenu en fonction de l'état de l'écran
                   when(state){
                       is DetailsState.Loading ->{
                           LoadingContent(modifier = Modifier)
                       }
                       is DetailsState.Success -> {
                          DetailsContent(user = state.data, onClick = actions.onBack)
                       }
                       is DetailsState.Error -> {
                           EmptyContent(modifier = Modifier)
                       }
                   }
               }
        }
    )
}

/**
 * Aperçu Jetpack Compose de l'écran des détails de l'utilisateur.
 */
@Composable
@Preview(name = "Details")
private fun DetailsScreenPreview() {
    DetailsScreen(
        state = DetailsState.Loading,
        actions = DetailsActions {  }
    )
}