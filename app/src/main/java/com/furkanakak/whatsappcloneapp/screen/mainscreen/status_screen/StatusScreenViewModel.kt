package com.furkanakak.whatsappcloneapp.screen.mainscreen.status_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanakak.whatsappcloneapp.common.Resource
import com.furkanakak.whatsappcloneapp.domain.usecase.StatusUseCase
import com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen.RecentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatusScreenViewModel @Inject constructor(private val statusUseCase: StatusUseCase)  : ViewModel() {
    private val _stateStatus = mutableStateOf(StatusState())
    val stateStatus : MutableState<StatusState> = _stateStatus
    init {
        getStatusData()
    }

    fun  getStatusData() = viewModelScope.launch {
        statusUseCase.invoke().collect{result ->
            when(result){

                Resource.Loading -> {
                    _stateStatus.value = StatusState(loading = true)
                }

                is Resource.Error -> {
                    _stateStatus.value = StatusState( error = result.errorMessage)
                }

                is Resource.Success -> {
                    _stateStatus.value = StatusState( success = result.data)
                }

            }

        }
    }
}