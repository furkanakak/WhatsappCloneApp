package com.furkanakak.whatsappcloneapp.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CustomFriendDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    dialogFriend: Friend
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { onDismiss() }
                    )
            ) {
                Column(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .height(300.dp)
                        .width(250.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {  }
                        )
                ) {
                    Box {
                        GlideImage(
                            imageModel = dialogFriend.picture,
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .height(250.dp).width(250.dp)
                                .align(Alignment.Center)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Black.copy(alpha = 0.2f))
                                .width(250.dp)
                                .height(35.dp)
                        ) {
                            Spacer(modifier = Modifier.width(8.dp))
                            dialogFriend.name?.let {
                                Text(
                                    text = it,
                                    fontSize = 20.sp,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.width(250.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(
                            imageVector = Icons.Default.Chat,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Chat",
                            modifier = Modifier.size(25.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Call,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Call",
                            modifier = Modifier.size(25.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Videocam,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Video",
                            modifier = Modifier.size(25.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Info,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Info",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            }
        }
    }
}