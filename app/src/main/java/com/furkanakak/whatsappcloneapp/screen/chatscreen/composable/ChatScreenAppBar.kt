package com.furkanakak.whatsappcloneapp.screen.chatscreen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.ui.theme.top_background
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreenAppBar(name :String,image : String,backTouchListener : () -> Unit,navigateToProfile : () -> Unit) {
    val cameraIcon: Painter = painterResource(id = R.drawable.ic_camera)
    TopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = top_background),
        modifier = Modifier.fillMaxWidth(),
        title = {
                Text(
                    modifier = Modifier.clickable { navigateToProfile() },
                    text = name,
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge
                )

        },
        navigationIcon = {

              Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier.clickable { backTouchListener() }) {
                  Icon(modifier = Modifier.size(24.dp), imageVector = Icons.Default.ArrowBack, contentDescription = "search", tint = Color.White)
                  Spacer(modifier = Modifier.size(8.dp))
                  GlideImage(
                      imageModel = image,
                      contentScale = ContentScale.Crop,
                      modifier = Modifier
                          .height(40.dp)
                          .width(40.dp)
                          .clip(CircleShape)
                  )
                  Spacer(modifier = Modifier.size(8.dp))
              }


        },
        actions = {
            Icon(imageVector = Icons.Default.Videocam,tint = Color.White,contentDescription = "Videocam", modifier = Modifier.size(30.dp))
            Spacer(modifier = Modifier.size(24.dp))
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Call,
                contentDescription = "search",
                tint = Color.White
            )
            Spacer(modifier = Modifier.size(16.dp))
            Icon(
                modifier = Modifier.size(26.dp),
                imageVector = Icons.Default.MoreVert,
                tint = Color.White,
                contentDescription = "more"
            )
        }
    )
}