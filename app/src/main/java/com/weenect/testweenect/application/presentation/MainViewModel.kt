package com.weenect.testweenect.application.presentation

import androidx.lifecycle.ViewModel
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * ViewModel principal utilisé pour gérer la logique métier et la navigation de l'application.
 * Cette classe est annotée avec @HiltViewModel pour être injectée via Hilt.
 *
 * @property appNavigator Le navigateur d'application utilisé pour gérer la navigation.
 */
@HiltViewModel
class MainViewModel @Inject constructor(appNavigator: AppNavigator) : ViewModel() {
    /**
     * Canal de navigation utilisé pour émettre des intentions de navigation vers l'interface utilisateur.
     */
    val navigationChannel = appNavigator.navigationChannel
}