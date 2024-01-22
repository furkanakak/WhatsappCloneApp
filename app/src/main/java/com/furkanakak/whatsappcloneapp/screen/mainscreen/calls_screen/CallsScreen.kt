package com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.DataSaverOn
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.furkanakak.whatsappcloneapp.common.components.CustomFriendDialog
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.furkanakak.whatsappcloneapp.domain.usecase.RecentUseCase
import com.furkanakak.whatsappcloneapp.screen.chatscreen.ChatScreenViewModel
import com.skydoves.landscapist.glide.GlideImage


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CallsScreen(viewModel: CallScreenViewModel = hiltViewModel()){

    val data : MutableState<RecentState> = viewModel.stateRecent
    var dataList by remember{ mutableStateOf<List<Friend>?>(mutableListOf()) }
    var showDialog by remember{ mutableStateOf(false) }
    var dialogFriend by remember{ mutableStateOf<Friend?>(null) }

    if(data.value.loading){
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()){
            CircularProgressIndicator()
        }
    }
    else if(data.value.error != null){
        Text(text = data.value.error!!)
    }
    else{
        val list : MutableList<Friend> = mutableListOf()
        list.add(Friend(arrayListOf(),-1,"",""))
        data.value.success?.friends?.let { list.addAll(it) }
        dataList = list
    }

    dialogFriend?.let { CustomFriendDialog(showDialog = showDialog, onDismiss = { showDialog = false }, dialogFriend = it) }

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(count = dataList!!.size, itemContent = { item ->

                RecentItem(friend = dataList!![item]) { friend ->
                    showDialog = true
                    dialogFriend = friend
                }

            })
        }


    }











}