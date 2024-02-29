package com.weenect.testweenect.application.presentation

import androidx.lifecycle.ViewModel
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(appNavigator: AppNavigator) : ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}