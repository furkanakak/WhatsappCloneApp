package com.furkanakak.whatsappcloneapp.screen.mainscreen.status_screen

import androidx.compose.foundation.layout.Box
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
import com.furkanakak.whatsappcloneapp.data.entity.Friend

@Composable
fun StatusScreen(viewModel: StatusScreenViewModel = hiltViewModel()) {
    val data: MutableState<StatusState> = viewModel.stateStatus
    var dataList by remember { mutableStateOf<List<Friend>?>(mutableListOf()) }

    if (data.value.loading) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()) {
            CircularProgressIndicator()
        }
    } else if (data.value.error != null) {
        Text(text = data.value.error!!)
    } else {
        val mutableList = mutableListOf<Friend>()
        mutableList.add(Friend(listOf(),-1,"",""))
        mutableList.addAll(data.value.success?.friends ?: listOf())
        dataList = (mutableList).take(4)
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(count = dataList?.size ?: 0, itemContent = { item ->
            StatusItem(friend = dataList!![item],position = item)
        })


    }


}




