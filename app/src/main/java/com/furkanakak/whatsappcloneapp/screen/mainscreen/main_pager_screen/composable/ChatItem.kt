package com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.furkanakak.whatsappcloneapp.data.entity.Chatlog
import com.furkanakak.whatsappcloneapp.ui.theme.md_theme_dark_onTertiary
import com.furkanakak.whatsappcloneapp.ui.theme.top_background
import kotlin.random.Random

@Composable
fun ChatItem(chatItem: Chatlog) {
    var color: Color = top_background
    val side = if (Random.nextInt(2) == 0) {
        Alignment.TopStart
    } else {
        color = md_theme_dark_onTertiary
        Alignment.TopEnd
    }

    chatItem.text?.let {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = side
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color)
                    .width(250.dp)
                    .padding(8.dp)
            ) {
                Column {
                    Text(text = chatItem.text!!, style = MaterialTheme.typography.bodyMedium)
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = chatItem.timestamp ?: "", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}
