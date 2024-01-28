package com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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

    dialogFriend?.let { CustomProfileDialog(showDialog = showDialog, onDismiss = { showDialog = false }, picture = it.picture?:"", name = it.name?:"") }

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