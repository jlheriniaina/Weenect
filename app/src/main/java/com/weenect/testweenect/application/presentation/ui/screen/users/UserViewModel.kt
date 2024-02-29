package com.weenect.testweenect.application.presentation.ui.screen.users

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weenect.testweenect.application.domaine.interactor.UserUseCase
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _stateFlow : MutableStateFlow<UserState> = MutableStateFlow(UserState.Idle)
    val stateFlow : StateFlow<UserState> = _stateFlow.asStateFlow()

    init {
        getUsers(0)
    }

    private fun getUsers(page : Int){
        viewModelScope.launch{
            userUseCase.getAllUser(page)
                .collect {
                    Log.d("TEST_APP", "TEST")
                    if (it.isNotEmpty()){
                        _stateFlow.value = UserState.Success(it)
                    }else {
                        _stateFlow.value = UserState.Empty
                    }
                }
        }
    }
}