package com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
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
import com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen.CallsScreen
import com.furkanakak.whatsappcloneapp.screen.mainscreen.status_screen.StatusScreen

import com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.composable.MainScreenAppBar
import com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen.ChatsScreen


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navigateToChatScreen : (Int) -> Unit) {

    var selectedTopIndex by remember  { mutableStateOf(0)}
    val list : List<String> = listOf("Chats","Status","Call")
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
                pageCount = list.size,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                when(selectedTopIndex){

                    EnumAppBar.Chats.value ->{
                        ChatsScreen(navigateToChatScreen = { id ->
                            navigateToChatScreen(id)})
                    }
                    EnumAppBar.Status.value ->{
                        StatusScreen()
                    }

                    EnumAppBar.Calls.value ->{
                        CallsScreen()
                    }
                }

            }

        }
    }, topBar = { MainScreenAppBar() })











}