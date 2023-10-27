package com.furkanakak.whatsappcloneapp.screen.mainscreen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.furkanakak.whatsappcloneapp.common.EnumAppBar
import com.furkanakak.whatsappcloneapp.common.components.TopBarWithPager
import com.furkanakak.whatsappcloneapp.screen.mainscreen.calls.CallsScreen
import com.furkanakak.whatsappcloneapp.screen.mainscreen.chats.ChatsScreen
import com.furkanakak.whatsappcloneapp.screen.mainscreen.main.composable.MainScreenAppBar
import com.furkanakak.whatsappcloneapp.screen.mainscreen.status.StatusScreen


@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navigateToChatScreen : (Int) -> Unit) {

    var selectedTopIndex by remember  { mutableStateOf(0)}
    val list : List<String> = listOf("Status","Chat","Call")
    val pagerState = rememberPagerState(initialPage = 0)


    LaunchedEffect(selectedTopIndex){
        pagerState.animateScrollToPage(selectedTopIndex)
    }
    LaunchedEffect(pagerState.currentPage){
        selectedTopIndex = pagerState.currentPage
    }


    Scaffold(content = {
        Column(Modifier.padding(it)) {
            TopBarWithPager(index = selectedTopIndex,list, clickItem = {})
            HorizontalPager(
                state = pagerState,
                pageCount = list.size ,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                when(selectedTopIndex){
                    EnumAppBar.Status.value ->{
                        StatusScreen(navigateToChatScreen = { id ->
                            navigateToChatScreen(id)})
                    }
                    EnumAppBar.Chats.value ->{
                        ChatsScreen()
                    }
                    EnumAppBar.Calls.value ->{
                        CallsScreen()
                    }
                }

            }

        }
    }, topBar = { MainScreenAppBar() })











}