package com.weenect.testweenect.application.presentation.ui.screen.users.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.weenect.testweenect.application.presentation.ui.theme.textColor

@Composable
fun UserContent(modifier : Modifier,
                users : List<User>, onSelected : (User) -> Unit){
   Box(modifier = modifier){
       LazyColumn {
           items(users){
               UserContentItem(it){
                   onSelected(it)
               }
           }
       }
   }
}

@Composable
fun UserContentItem(item : User, onSelected : () -> Unit){
    Card(
        modifier = Modifier
            .padding(Dimensions.size_s())
            .clickable { onSelected() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme())
                MaterialTheme.colorScheme.background else Color.White,
        )
    ) {
       Row(Modifier
           .padding(horizontal = Dimensions.size_s(),
                    vertical = Dimensions.size_s())){
           AsyncImage(
               model = ImageRequest.Builder(LocalContext.current)
                   .data(item.avatarProfil)
                   .transformations(CircleCropTransformation())
                   .build(),
               contentDescription = "",
               modifier = Modifier
                          .size(60.dp)
           )
           Column(modifier = Modifier
               .fillMaxWidth()
               .padding(start = Dimensions.size_s(),
                        end = Dimensions.size_s())
           ) {
               Text(text = item.name,
                   fontWeight = FontWeight.SemiBold,
                   color = MaterialTheme.colorScheme.textColor)
               Text(text = item.firstname,
                   color = MediumGray)
           }

       }
    }
}