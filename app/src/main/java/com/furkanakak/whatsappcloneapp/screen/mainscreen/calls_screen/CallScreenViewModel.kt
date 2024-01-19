package com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanakak.whatsappcloneapp.common.Resource
import com.furkanakak.whatsappcloneapp.domain.usecase.ChatScreenUseCase
import com.furkanakak.whatsappcloneapp.domain.usecase.RecentUseCase
import com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen.ChatsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CallScreenViewModel @Inject constructor(private val regentScreenUseCase: RecentUseCase) : ViewModel() {
    private val _stateRecent = mutableStateOf(RecentState())
    val stateRecent : MutableState<RecentState> = _stateRecent
    init {
        getRecentData()
    }


    fun  getRecentData() = viewModelScope.launch {
        regentScreenUseCase.invoke().collect{result ->
            when(result){

                Resource.Loading -> {
                    _stateRecent.value = RecentState(loading = true)
                }

                is Resource.Error -> {
                    _stateRecent.value = RecentState( error = result.errorMessage)
                }

                is Resource.Success -> {
                    _stateRecent.value = RecentState( success = result.data)
                }

            }

        }
    }


}