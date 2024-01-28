package com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.furkanakak.whatsappcloneapp.common.components.CustomProfileDialog
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.furkanakak.whatsappcloneapp.data.entity.FriendX
import com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen.composable.FriendsRow

@SuppressLint("UnrememberedMutableState")
@Composable
fun ChatsScreen(viewModel: ChatsViewModel = hiltViewModel(), navigateToChatScreen : (Int) -> Unit) {

    val data : MutableState<ChatsState> = viewModel.stateFavorite
    var dialogFriend by remember{ mutableStateOf<FriendX?>(null) }
    var showDialog by remember{ mutableStateOf(false) }



    dialogFriend?.let { CustomProfileDialog(showDialog = showDialog, onDismiss = { showDialog = false }, picture = it.picture?:"", name = it.name?:"") }


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
                    } ,openDialog = { friend ->
                        showDialog = true
                        dialogFriend = friend
                    })

                }
            })
        }
    }








}