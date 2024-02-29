package com.weenect.testweenect.application.presentation.ui.screen.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.domaine.interactor.UserUseCase
import com.weenect.testweenect.application.presentation.navigation.AppNavigator
import com.weenect.testweenect.application.presentation.ui.screen.users.contractor.UserState
import com.weenect.testweenect.helpers.CheckInternet
import com.weenect.testweenect.helpers.Destination
import com.weenect.testweenect.helpers.NavigationConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val userUseCase: UserUseCase,
    private val checkInternet: CheckInternet
) : ViewModel() {
    private val _stateFlow : MutableStateFlow<UserState> = MutableStateFlow(UserState.Idle)
    val stateFlow : StateFlow<UserState> = _stateFlow.asStateFlow()
    private val _networkState  = MutableStateFlow<Boolean>(true)
    val networkState = _networkState.asStateFlow()
    private var currentPage = 0
    private val users = mutableListOf<User>()
    init {
        getUsers()
    }
    fun getUsers(){
        currentPage++
        viewModelScope.launch{
            userUseCase.getAllUser(currentPage)
                .collect {
                    if (it.isNotEmpty()){
                         users.addAll(it)
                        _stateFlow.value = UserState.Success(users.toList())
                    }else {
                        _stateFlow.value = UserState.Empty
                }
            }
        }
    }

    fun checkNetwork(){
        checkInternet.isCheck {
           _networkState.value = it
        }
    }
    fun openDetails(){
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.DetailsUserScreen(), NavigationConstant.USER_SCREEN)
        }
    }
}