package com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanakak.whatsappcloneapp.common.Resource
import com.furkanakak.whatsappcloneapp.domain.usecase.FriendsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(private  val friendsUseCase: FriendsUseCase) : ViewModel(){

    private val _stateFavorite = mutableStateOf(ChatsState())
    val stateFavorite : MutableState<ChatsState> = _stateFavorite

    init {
        getChatData()
    }

     fun  getChatData() = viewModelScope.launch {
        friendsUseCase.invoke().collect{result ->
            when(result){

                Resource.Loading -> {
                    _stateFavorite.value = ChatsState(loading = true)
                }

                is Resource.Error -> {
                    _stateFavorite.value = ChatsState( error = result.errorMessage)
                }

                is Resource.Success -> {
                    _stateFavorite.value = ChatsState( success = result.data)
                }

            }

        }
    }



}