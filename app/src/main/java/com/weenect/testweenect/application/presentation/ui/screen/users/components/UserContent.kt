package com.weenect.testweenect.application.presentation.ui.screen.users.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserActions
import com.weenect.testweenect.helpers.extentions.scrollEndCallback
import kotlinx.coroutines.launch

/**
 * Compose le contenu principal de l'écran des listes utilisateurs.
 *
 * @param modifier // Le [Modifier] pour modifier le comportement ou l'apparence du contenu.
 * @param users   // La liste des utilisateurs à afficher.
 * @param netSate // L'état de la connexion réseau.
 * @param actions // Les actions à exécuter dans l'écran des utilisateurs.
 */
@Composable
fun UserContent(modifier : Modifier,
                users : List<User>,
                netSate : Boolean,
                actions: UserActions){
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = modifier,state = scrollState.also {
        it.scrollEndCallback {
            coroutineScope.launch {
                actions.onNetworkActive()
                if (netSate){
                    actions.onLoadMoreItem()
                }
            }
        }
    },){
        items(users){
            UserContentItem(it){
                actions.onSelectedItem(it)
            }
        }
    }
}

