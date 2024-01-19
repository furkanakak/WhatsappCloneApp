package com.furkanakak.whatsappcloneapp.screen.mainscreen.status_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.data.entity.Chatlog
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.furkanakak.whatsappcloneapp.ui.theme.white

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



