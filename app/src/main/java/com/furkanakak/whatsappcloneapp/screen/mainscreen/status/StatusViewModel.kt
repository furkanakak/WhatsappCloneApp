package com.furkanakak.whatsappcloneapp.screen.mainscreen.status

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanakak.whatsappcloneapp.common.Resource
import com.furkanakak.whatsappcloneapp.domain.usecase.FriendsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatusViewModel @Inject constructor(private  val friendsUseCase: FriendsUseCase) : ViewModel(){

    private val _stateFavorite = mutableStateOf(StatusState())
    val stateFavorite : MutableState<StatusState> = _stateFavorite

    init {
        getChatData()
    }

     fun  getChatData() = viewModelScope.launch {
        friendsUseCase.invoke().collect{result ->
            when(result){

                Resource.Loading -> {
                    _stateFavorite.value = StatusState(loading = true)
                }

                is Resource.Error -> {
                    _stateFavorite.value = StatusState( error = result.errorMessage)
                }

                is Resource.Success -> {
                    _stateFavorite.value = StatusState( success = result.data)
                }

            }

        }
    }



}