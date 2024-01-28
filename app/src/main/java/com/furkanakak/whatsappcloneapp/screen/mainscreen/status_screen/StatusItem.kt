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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.furkanakak.whatsappcloneapp.ui.theme.white
import kotlin.random.Random


@Composable
fun StatusItem(friend: Friend,position: Int) {

    val hour = Random.nextInt(24)
    val minute = Random.nextInt(60)
    val time = String.format("%02d:%02d", hour, minute)


    fun getDrawableIdByPosition(position: Int): Int {
        return when (position) {
            1 -> R.drawable.view_status_1
            2 -> R.drawable.view_status_2
            3 -> R.drawable.view_status_3
            else -> R.drawable.view_status_1
        }
    }
    if (position != 0) {
        Column(modifier = Modifier.fillMaxWidth().padding(start = 8.dp,end = 8.dp)) {
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(getDrawableIdByPosition(position)),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(friend.name ?: "", fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(time, fontSize = 14.sp)
                }

            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    else{
        Column(modifier = Modifier.fillMaxHeight().padding(start = 8.dp)) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text("Status", fontSize = 18.sp)
                    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                        }
                    }
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.my_profile_image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                            )

                            Box(
                                modifier = Modifier
                                    .size(18.dp)
                                    .align(Alignment.BottomEnd)
                                    .background(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add",
                                    tint = white,
                                    modifier = Modifier
                                        .background(
                                            color = MaterialTheme.colorScheme.onPrimary,
                                            shape = CircleShape
                                        )
                                        .size(28.dp)
                                        .align(Alignment.Center)
                                )

                            }


                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Column(modifier = Modifier.padding(start = 16.dp)) {
                            Text("My Status", fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Tap to add status update", fontSize = 14.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                        Text("Recent updates",fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                }


            }


        }
    }




}



