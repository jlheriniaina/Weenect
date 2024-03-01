package com.weenect.testweenect.application.presentation.ui.screen.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.presentation.ui.theme.Dimensions
import com.weenect.testweenect.application.presentation.ui.theme.MediumGray
import com.weenect.testweenect.application.presentation.ui.theme.PrimaryDark
import com.weenect.testweenect.application.presentation.ui.theme.textColor

/**
 * Compose le contenu des informations détaillées de l'utilisateur.
 *
 * @param modifier Le [Modifier] pour modifier le comportement ou l'apparence du contenu.
 * @param user L'utilisateur dont les informations doivent être affichées.
 */
@Composable
fun DetailsInfoUserContent(
    modifier: Modifier,
    user: User) {
    Box(
        modifier= modifier
            .fillMaxWidth()
            .height(250.dp)
            .shadow(
                4.dp,
                MaterialTheme.shapes.medium
            )
            .background(
                if (isSystemInDarkTheme())
                    MaterialTheme.colorScheme.background else Color.White,
                MaterialTheme.shapes.medium
            ),
        contentAlignment = Alignment.BottomCenter){

        Column(
            Modifier
                .fillMaxWidth()){
            Row(Modifier
                .padding(horizontal = Dimensions.size_s(),
                    vertical = Dimensions.size_s())){

                // Affichage de l'image de profil de l'utilisateur
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(user.avatarProfil)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .size(90.dp)
                )

                // Affichage des détails de l'utilisateur
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = Dimensions.size_s(),
                        end = Dimensions.size_s(),
                        bottom = Dimensions.size_s()
                    )
                ) {
                    Text(text = user.name,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.textColor)

                    Text(text = user.firstname,
                        color = MediumGray
                    )
                    Row(horizontalArrangement = Arrangement.SpaceBetween){
                        Icon(imageVector = Icons.Filled.LocationOn,
                            contentDescription = "", tint = PrimaryDark)
                        Text(text = user.address,
                             color = MaterialTheme.colorScheme.textColor,
                             modifier = Modifier.padding(start = Dimensions.size_m())
                        )
                    }

                    Row(horizontalArrangement = Arrangement.SpaceBetween){
                        Icon(imageVector = Icons.Filled.Phone,
                             contentDescription = "", tint = Color.Green)
                        Text(text = user.phone ?: "",
                            color = MaterialTheme.colorScheme.textColor,
                            modifier = Modifier.padding(start = Dimensions.size_m())
                        )
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween){
                        Icon(imageVector = Icons.Filled.Email,
                            contentDescription = "", tint = MediumGray)
                        Text(text = user.email ?: "",
                             color = MaterialTheme.colorScheme.textColor,
                             modifier = Modifier.padding(start = Dimensions.size_m())
                        )
                    }
                   Spacer(modifier = Modifier.weight(1.0f))
                }
            }
        }
    }
}