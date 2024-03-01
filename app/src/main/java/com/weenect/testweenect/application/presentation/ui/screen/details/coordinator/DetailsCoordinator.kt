package com.weenect.testweenect.application.presentation.ui.screen.details.coordinator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.weenect.testweenect.application.presentation.ui.screen.details.DetailsViewModel

/**
 * Classe responsable de la coordination entre la logique métier du ViewModel et l'interface utilisateur
 * pour les détails de l'utilisateur.
 *
 * @property viewModel Le ViewModel gérant la logique métier des détails de l'utilisateur.
 */
class DetailsCoordinator(val viewModel: DetailsViewModel){
    // DataFlow d'état des détails de l'utilisateur
    val stateFlow = viewModel.stateFlow

    /**
     * Fonction appelée lorsqu'un retour en arrière est demandé dans l'écran des détails de l'utilisateur.
     */
    fun onBackPressed(){
        viewModel.navigationBack()
    }

}

/**
 * Crée et retient une instance de DetailsCoordinator en utilisant le ViewModel passé en paramètre.
 *
 * @param viewModel Le ViewModel des détails de l'utilisateur, récupéré via Hilt.
 * @return L'instance de DetailsCoordinator associée au ViewModel.
 */
@Composable
fun rememberDetailsCoordinator(viewModel: DetailsViewModel = hiltViewModel()) : DetailsCoordinator {
    return remember(viewModel){
           DetailsCoordinator(viewModel)
    }
}