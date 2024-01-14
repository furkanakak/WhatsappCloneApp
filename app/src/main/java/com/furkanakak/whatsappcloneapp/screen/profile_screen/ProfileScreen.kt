package com.furkanakak.whatsappcloneapp.screen.profile_screen

import android.util.Base64
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.data.entity.FriendX
import com.furkanakak.whatsappcloneapp.ui.theme.md_theme_dark2_surface
import com.furkanakak.whatsappcloneapp.ui.theme.md_theme_soft_red
import com.furkanakak.whatsappcloneapp.ui.theme.top_background
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun ProfileScreen(selectedProfile : String?, onBackClick : () -> Unit) {
    var profile by remember { mutableStateOf<FriendX?>(null)}
    var progress by remember { mutableStateOf(0f) }
    var notificationSwitch by remember { mutableStateOf(false) }
    var scrollRatio  by remember { mutableStateOf(0f) }
    val scrollState = rememberScrollState()
    val profileJsonString = String(Base64.decode(selectedProfile, Base64.NO_WRAP))
     profile = Json.decodeFromString<FriendX>(profileJsonString)

    LaunchedEffect(scrollState.value){
         scrollRatio = if (scrollState.maxValue > 0) {
            scrollState.value.toFloat() / scrollState.maxValue
        } else {
            0f
        }
    }

    Column {
        ProfileHeader(progress = scrollRatio,profile = profile,onBackClick)
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Spacer(modifier = Modifier.height(130.dp))
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(style = MaterialTheme.typography.titleLarge,text = profile?.name?:"")
                Spacer(modifier = Modifier.height(4.dp))
                Text(style = MaterialTheme.typography.titleLarge,text = "0552 297 98 06")

            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.width(250.dp)) {
                    Column {
                        IconButton(  modifier = Modifier.size(24.dp), onClick = { } ) { Icon(Icons.Filled.Call,"", tint = MaterialTheme.colorScheme.primary ,modifier = Modifier.size(25.dp))}
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Sesli")
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(  modifier = Modifier.size(24.dp), onClick = { } ) { Icon(Icons.Default.CameraAlt,"",tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(25.dp)) }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Görüntülü")
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Column {
                        IconButton(  modifier = Modifier.size(24.dp), onClick = { } ) { Icon(Icons.Default.Search,"",tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(25.dp)) }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Ara")
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            Spacer(modifier = Modifier
                .height(8.dp)
                .background(md_theme_dark2_surface)
                .fillMaxWidth())
            Column(Modifier.padding(start = 10.dp, end = 10.dp)) {
                Spacer(modifier = Modifier .height(16.dp))
                Text(text = "Meşgul")
                Spacer(modifier = Modifier .height(8.dp))
                Text(text = "10 Kasım")
                Spacer(modifier = Modifier .height(16.dp))
            }
            Spacer(modifier = Modifier
                .height(8.dp)
                .background(md_theme_dark2_surface)
                .fillMaxWidth())
            Column(Modifier.padding(start = 8.dp, end = 8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxWidth()) {
                    Row {
                        IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_notifications ),"Notification",tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(25.dp)) }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Bildirimleri sesize al")
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Row {
                        Switch(checked = notificationSwitch,onCheckedChange = {  notificationSwitch = it }, modifier = Modifier.height(16.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_music),"Notification",tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Özel bildirimler")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_image),"Notification",tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Medya görünürlüğü")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier
                .height(8.dp)
                .background(md_theme_dark2_surface)
                .fillMaxWidth())
            Column(Modifier.padding(start = 8.dp, end = 8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_lock ),"Notification",tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Şifreleme")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = "Mesajlar ve aramalar uçtan uca şifrelidir. Doğrulamak için dokunun")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_rotate),"Notification",tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Süreli mesajlar")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = "Kapalı")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_chatlock),"Notification",tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Sohbet kilidi")


                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier
                .height(8.dp)
                .background(md_theme_dark2_surface)
                .fillMaxWidth())
            Column(Modifier.padding(start = 8.dp, end = 8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_block),"Notification",tint = md_theme_soft_red, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "${profile?.name?:""} kişisini engelle")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { } ) { Icon(painter = painterResource(id = R.drawable.ic_down),"Notification",tint = md_theme_soft_red, modifier = Modifier.size(25.dp)) }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "${profile?.name?:""} kişisini şikayet et")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }



}
@OptIn(ExperimentalMotionApi::class)
@Composable
fun ProfileHeader(progress: Float,profile : FriendX?,onBackClick : () -> Unit) {
    val name by remember { mutableStateOf(profile?.name?:"") }
    val context = LocalContext.current
    val motionScene = remember { context.resources.openRawResource(R.raw.motion_scene_profile).readBytes().decodeToString() }
        MotionLayout(motionScene = MotionScene(content = motionScene), progress = progress, modifier = Modifier.fillMaxWidth()) {
            val properties = motionProperties(id = "profile_pic")

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(top_background)
                .layoutId("box"))

            GlideImage(
                imageModel = profile?.picture,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clip(CircleShape)
                    .layoutId("profile_pic")
            )

            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White,
                modifier = Modifier.layoutId("back_arrow_pic").clickable {onBackClick()})
            Icon(modifier = Modifier.layoutId("more_pic"), imageVector = Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)

            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.layoutId("username"),
                color = properties.value.color("background")
            )


        }


}


