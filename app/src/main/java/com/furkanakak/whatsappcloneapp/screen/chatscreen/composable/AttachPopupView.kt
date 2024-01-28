package com.furkanakak.whatsappcloneapp.screen.chatscreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.furkanakak.whatsappcloneapp.ui.theme.top_background

@Composable
fun AttachPopupView(showDialog: Boolean, onDismiss: () -> Unit) {

    val attachList = remember { mutableStateOf<List<AttachItem>>(emptyList()) }

    setAttachList(attachList)

    if (showDialog) {
        Popup(
            alignment = Alignment.BottomCenter,
            onDismissRequest = { onDismiss() },
            offset = IntOffset(x = 0, y = -220)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(top_background, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = top_background),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),

            ) {

                Column(
                    modifier = Modifier
                        .height(300.dp)
                        .background(top_background)
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        items(
                            count = attachList.value.size, itemContent = { position ->
                                ItemAttach(attachList.value[position])
                            }
                        )
                    }


                }
            }
        }
    }
}

fun setAttachList(attachList: MutableState<List<AttachItem>>) {
    val list = mutableListOf<AttachItem>()
    list.add(AttachItem(Icons.Default.InsertDriveFile,title = "Document",containerColor = Color(0xFF7F5AF8)))
    list.add(AttachItem( Icons.Default.CameraAlt, title = "Camera",  containerColor = Color(0xFFee1374)))
    list.add(AttachItem(Icons.Default.Image, title = "Gallery", containerColor = Color(0xFFc24cf3)))
    list.add(AttachItem(Icons.Default.Headset, title = "Audio", containerColor = Color(0xFFed5936)))
    list.add( AttachItem(Icons.Default.LocationOn,title = "Location",containerColor = Color(0xFF29be63)))
    list.add(AttachItem(Icons.Default.Person, title = "Contact", containerColor = Color(0xFF0fa8dd)))
    list.add(AttachItem( Icons.Default.AutoGraph,title = "Poll", containerColor = Color(0xFF10a98c)))
    attachList.value = list

}

@Composable
fun ItemAttach(item: AttachItem) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        Card(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = item.containerColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = item.icon,
                    contentDescription = "search",
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = item.title, color = Color.White, fontSize = 12.sp)
    }
}

data class AttachItem(var icon: ImageVector, var title: String, var containerColor: Color)