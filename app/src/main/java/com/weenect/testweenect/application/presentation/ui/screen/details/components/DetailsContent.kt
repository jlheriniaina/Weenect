package com.weenect.testweenect.application.presentation.ui.screen.details.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.constraintlayout.compose.ConstraintLayout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.weenect.testweenect.application.domaine.entities.User


/**
 * Compose le contenu de l'écran des détails de l'utilisateur.
 *
 * @param user L'utilisateur dont les détails doivent être affichés.
 * @param onClick L'action à exécuter lorsqu'un bouton est cliqué.
 */
@Composable
fun DetailsContent(user : User, onClick : () -> Unit){

    // État de la caméra pour contrôler la position sur la carte
    val cameraState = rememberCameraPositionState()

    // Effet lancé pour centre la carte sur la position de l'utilisateur
    LaunchedEffect(key1 = LatLng(user.lat, user.lng)) {
        cameraState.centerOnLocation(LatLng(user.lat, user.lng))
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (content, footer) = createRefs()

        // Carte Google Maps affichant la position de l'utilisateur
        GoogleMap(
            modifier = Modifier.constrainAs(content) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            cameraPositionState = cameraState,
            properties = MapProperties(
                mapType = MapType.NORMAL,
                isTrafficEnabled = true
            )
        ) {
            // Marqueur indiquant la position de l'utilisateur sur la carte
            Marker(
                state = MarkerState(position = LatLng(user.lat, user.lng)),
                title = "${user.title}. ${user.name} ${user.firstname}",
                snippet = user.address
            )
        }
        // Contenu des informations détaillées de l'utilisateur
        DetailsInfoUserContent(
            modifier =
            Modifier.constrainAs(footer) {
                   start.linkTo(parent.start)
                   end.linkTo(parent.end)
                   bottom.linkTo(parent.bottom)
            },
            user = user)
    }
    // Bouton de fermeture des détails de l'utilisateur
    DetailsButtonContent(onClick = onClick)
}


/**
 * Fonction d'extension suspendue pour centrer la caméra sur une position donnée sur la carte.
 *
 * @param location La position à centrer sur la carte.
 */
private suspend fun CameraPositionState.centerOnLocation(
    location: LatLng
) = animate(
    update = CameraUpdateFactory.newLatLngZoom(
        location,
        10f
    ),
    durationMs = 1500
)