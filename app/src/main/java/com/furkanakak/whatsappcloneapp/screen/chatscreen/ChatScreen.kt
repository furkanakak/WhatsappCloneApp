package com.furkanakak.whatsappcloneapp.screen.chatscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.data.entity.Chatlog
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.furkanakak.whatsappcloneapp.data.entity.FriendX
import com.furkanakak.whatsappcloneapp.screen.chatscreen.composable.AttachPopupView
import com.furkanakak.whatsappcloneapp.screen.chatscreen.composable.ChatScreenAppBar
import com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen.ChatsState
import com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.composable.ChatItem
import com.furkanakak.whatsappcloneapp.ui.theme.md_theme_dark_onPrimary
import com.furkanakak.whatsappcloneapp.ui.theme.top_background
import androidx.compose.material3.Text as hintT


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChatScreen(
    viewModel: ChatScreenViewModel = hiltViewModel(),
    id: Int,
    popBackStack: () -> Unit,
    navigateToProfile: (FriendX?) -> Unit
) {

    val data: MutableState<ChatsState> = viewModel.stateFavorite
    var selectedItem by remember { mutableStateOf<Friend?>(null) }
    var selectedProfile by remember { mutableStateOf<FriendX?>(null) }
    var chatList by remember { mutableStateOf<List<Chatlog>?>(null) }
    var isAttachDialog by remember { mutableStateOf(false) }


    if (data.value.loading) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()) {
            CircularProgressIndicator()
        }
    } else if (data.value.error != null) {
        hintT(text = data.value.error!!)
    } else {
        selectedItem = data.value.success?.friends?.filter { it.id == id }?.get(0)
        chatList = selectedItem?.chatlog
    }


    AttachPopupView(isAttachDialog, onDismiss = {
        isAttachDialog = false
    })

    Scaffold(
        content = {
            Column(Modifier.padding(it)) {
                LazyColumn(
                    Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    items(count = chatList?.size ?: 0, itemContent = { position ->
                        chatList?.get(position)?.let { item ->
                            ChatItem(chatItem = item)
                        }
                    })
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 8.dp)
                ) {
                    BottomMessage(Modifier.align(Alignment.BottomCenter)){
                        isAttachDialog = true
                    }
                }
            }
        },
        topBar = {
            ChatScreenAppBar(
                name = selectedItem?.name ?: "",
                image = selectedItem?.picture ?: "",
                backTouchListener = {
                    popBackStack()
                },
                navigateToProfile = {
                    selectedProfile = data.value.success?.profile?.friends?.filter {
                        it.id == id
                    }?.get(0)

                    navigateToProfile(selectedProfile)
                }
            )
        }
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomMessage(modifier: Modifier,attachOnClick : () -> Unit = {}) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .background(top_background, RoundedCornerShape(16.dp)),
            Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Spacer(Modifier.width(8.dp))
            IconButton(onClick = {},Modifier.size(24.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_emoji),
                    contentDescription = "search",
                    tint = Color.LightGray
                )
            }

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .width(150.dp)
                    .then(Modifier.background(top_background, RoundedCornerShape(16.dp))),
                placeholder = { hintT("Massage", fontSize = 16.sp, color = Color.White, modifier =  Modifier.alpha(0.7f)) },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Transparent,
                    errorCursorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedPlaceholderColor = Color.Transparent,
                    containerColor = top_background,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp)
            )
            IconButton(onClick = {
                attachOnClick()
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_attach),
                    contentDescription = "search",
                    tint = Color.LightGray
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "search",
                    tint = Color.LightGray
                )
            }


        }
        Spacer(Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape(16.dp))
                .background(md_theme_dark_onPrimary)

        ) {
            IconButton(onClick = {}) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_voice),
                    contentDescription = "voice",
                    tint = Color.LightGray
                )
            }
        }
    }


}

