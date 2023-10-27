package com.furkanakak.whatsappcloneapp.screen.mainscreen.status

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.furkanakak.whatsappcloneapp.screen.chatscreen.ChatScreen
import com.furkanakak.whatsappcloneapp.screen.mainscreen.status.composable.FriendsRow

@SuppressLint("UnrememberedMutableState")
@Composable
fun StatusScreen(viewModel: StatusViewModel = hiltViewModel(),navigateToChatScreen : (Int) -> Unit) {

    val data : MutableState<StatusState> = viewModel.stateFavorite


    if(data.value.loading){
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()){
            CircularProgressIndicator()
        }
    }
    else if(data.value.error != null){
        Text(text = data.value.error!!)
    }
    else{
        LazyColumn {
            items(count = (data.value.success?.friends?.size)?:0, itemContent = { position ->
                data.value.success?.profile?.friends?.get(position)?.let { item ->
                    FriendsRow(item, onClick = {
                        item.id?.let { navigateToChatScreen(it) }
                    } )

                }
            })
        }
    }








}