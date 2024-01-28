package com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.composable

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.ui.theme.top_background

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenAppBar() {
    var showMenu by remember { mutableStateOf(false) }
    var itemHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    var dpOffset by remember { mutableStateOf(DpOffset(0.dp, 0.dp)) }
    val cameraIcon: Painter = painterResource(id = R.drawable.ic_camera)




        TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = top_background),
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    itemHeight = with(density) {
                        (it.height.toDp())
                    }
                    Log.v("onSizeChanged", "onSizeChanged -> $itemHeight")
                }
            ,
            title = {
                Text(
                    text = "WhatsApp",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge
                )

            },
            actions = {
                Icon(painter = cameraIcon, contentDescription = "camera", modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.size(24.dp))
                Icon(modifier = Modifier.size(24.dp), imageVector = Icons.Default.Search, contentDescription = "search", tint = Color.LightGray)
                Spacer(modifier = Modifier.size(24.dp))
                Icon(imageVector = Icons.Default.MoreVert, tint = Color.LightGray, contentDescription = "more",modifier = Modifier
                    .size(26.dp)
                    .onGloballyPositioned { layoutCoordinates ->
                        dpOffset = Offset( layoutCoordinates.positionInParent().x,  layoutCoordinates.positionInParent().y ).let { offset ->
                            DpOffset(offset.x.dp, offset.y.dp)
                        }
                    }
                    .clickable { showMenu = !showMenu })


            }
        )

    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false },
        modifier = Modifier
            .background(color = top_background)
            .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
            .width(170.dp),
        offset =DpOffset(x = (dpOffset.x-10.dp), y = (itemHeight- LocalConfiguration.current.screenHeightDp.dp+10.dp))


    ) {
        DropdownMenuItem(
            text = { Text("New group") },
            onClick = { }

        )
        DropdownMenuItem(
            text = { Text("New broadcast") },
            onClick = { }
        )
        DropdownMenuItem(
            text = { Text("Linked devices") },
            onClick = { }
        )
        DropdownMenuItem(
            text = { Text("Starred messages") },
            onClick = { }
        )
        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = { }
        )

    }

}


