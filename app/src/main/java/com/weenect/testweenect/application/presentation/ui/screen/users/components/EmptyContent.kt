package com.weenect.testweenect.application.presentation.ui.screen.users.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.weenect.testweenect.R
import com.weenect.testweenect.application.presentation.ui.theme.Dimensions
import com.weenect.testweenect.application.presentation.ui.theme.MediumGray

@Composable
fun EmptyContent(modifier: Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.size_m()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "",
                    modifier = Modifier.size(Dimensions.size_xxl())
                )
            }
            Spacer(modifier = Modifier.size(Dimensions.size_m()))
            Text(
                text = stringResource(R.string.txt_error_empty_user), style = TextStyle(
                    fontSize = Dimensions.text_m(),
                    color = MediumGray
                )
            )
        }
    }
}