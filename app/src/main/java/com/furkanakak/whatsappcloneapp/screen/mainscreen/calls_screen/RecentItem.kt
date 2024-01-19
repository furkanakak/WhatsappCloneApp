package com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.DataSaverOn
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanakak.whatsappcloneapp.R
import com.furkanakak.whatsappcloneapp.data.entity.Friend
import com.skydoves.landscapist.glide.GlideImage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecentItem (friend : Friend) {

    val year = Random().nextInt(2025 - 2020) + 2020
    val month = Random().nextInt(12) + 1
    val dayOfMonth = Random().nextInt(27) + 1
    val hour = Random().nextInt(24)
    val minute = Random().nextInt(60)

    val randomDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute)
    val formatter = DateTimeFormatter.ofPattern("MMMM dd, HH:mm")
    val formatterDate = randomDateTime.format(formatter)

    val icon = if (Random().nextInt(3) == 1) {
        Icons.Default.CameraAlt
    } else {
        Icons.Default.Call

    }

    if (friend.id != -1) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {}) {
                    GlideImage(
                        imageModel = friend.picture ?: "",
                        modifier = Modifier
                            .size(55.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentDescription = "",
                        failure = {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = "",
                                tint = Color.LightGray,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = friend.name ?: "", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = formatterDate, style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }


            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    } else {
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Row {
                Icon(
                    imageVector = Icons.Filled.DataSaverOn,
                    contentDescription = "Profile",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Create call link",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Share a link for your WhatsApp call",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 13.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Recent", modifier = Modifier.fillMaxWidth(), fontSize = 16.sp)
        }


    }
}