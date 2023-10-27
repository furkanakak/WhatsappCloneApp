package com.furkanakak.whatsappcloneapp.screen.mainscreen.main.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.ui.theme.top_background

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenAppBar() {
    val cameraIcon: Painter = painterResource(id = R.drawable.ic_camera)
        TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = top_background),
            modifier = Modifier
                .fillMaxWidth(),
            title = {
                Text(
                    text = "WhatsApp",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            actions = {
                Icon(painter = cameraIcon, contentDescription = "more", modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.size(24.dp))
                Icon(modifier = Modifier.size(24.dp), imageVector = Icons.Default.Search, contentDescription = "search", tint = Color.LightGray)
                Spacer(modifier = Modifier.size(24.dp))
                Icon(modifier = Modifier.size(26.dp), imageVector = Icons.Default.MoreVert, tint = Color.LightGray, contentDescription = "more")
            }
        )

}