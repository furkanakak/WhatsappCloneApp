package com.furkanakak.whatsappcloneapp.screen.profilescreen

import android.util.Base64
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.data.entity.FriendX
import com.furkanakak.whatsappcloneapp.ui.theme.top_background
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun ProfileScreen(selectedProfile : String?) {
    var profile by remember { mutableStateOf<FriendX?>(null)}
    var progress by remember { mutableStateOf(0f) }
    val profileJsonString = String(Base64.decode(selectedProfile, Base64.NO_WRAP))
    profile = Json.decodeFromString<FriendX>(profileJsonString)
    Log.v("profile","profile3 : ${profile?.name}")


    Column {
        ProfileHeader(progress = progress,profile = profile)
        Spacer(modifier = Modifier.height(102.dp))
        Slider(value = progress, onValueChange = { progress = it }, modifier = Modifier.padding(horizontal = 32.dp))
    }



}
@OptIn(ExperimentalMotionApi::class)
@Composable
fun ProfileHeader(progress: Float,profile : FriendX?) {
    val context = LocalContext.current
    val motionScene = remember { context.resources.openRawResource(R.raw.motion_scene_profile).readBytes().decodeToString() }
    MotionLayout(motionScene = MotionScene(content = motionScene), progress = progress, modifier = Modifier.fillMaxWidth()) {
        val properties = motionProperties(id = "profile_pic")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(top_background)
                .layoutId("box")
        )

        GlideImage(
            imageModel = profile?.picture,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clip(CircleShape)
                .layoutId("profile_pic")
        )

        Icon(modifier = Modifier.layoutId("back_arrow_pic"), imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
        Icon(modifier = Modifier.layoutId("more_pic"), imageVector = Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)

        Text(
            text = "Philipp Lackner",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.layoutId("username"),
            color = properties.value.color("background")
        )
    }
}