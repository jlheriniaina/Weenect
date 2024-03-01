package com.weenect.testweenect.application.presentation.ui.screen.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.weenect.testweenect.application.presentation.ui.theme.Dimensions
import com.weenect.testweenect.application.presentation.ui.theme.Primary

/**
 * Compose le contenu du bouton de fermeture des détails de l'utilisateur.
 *
 * @param onClick L'action à exécuter lorsque le bouton est cliqué.
 */
@Composable
fun DetailsButtonContent(onClick : () -> Unit) {
    Box(
        modifier= Modifier
            .padding(top = Dimensions.size_xl(),
                start = Dimensions.size_s())
            .size(40.dp)
            .aspectRatio(1f)
            .background(Primary, shape = CircleShape),
        contentAlignment = Alignment.TopCenter){
        IconButton(onClick = {
            onClick()
        }) {
            Icon(imageVector = Icons.Rounded.Clear,
                contentDescription ="", tint = Color.White,
                modifier = Modifier.size(30.dp))
        }
    }
}