package com.furkanakak.whatsappcloneapp.common.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import com.furkanakak.whatsappcloneapp.ui.theme.top_background

@Composable
fun TopBarWithPager(index : Int,tabTitles : List<String> , clickItem : (Int)  -> Unit) {
    var selectedItem by remember { mutableStateOf(0) }

            TabRow(
                selectedTabIndex = index,
                containerColor =  top_background,
                contentColor = MaterialTheme.colorScheme.primary,

                ){
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            clickItem(selectedItem)
                        },
                        text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) },
                        selectedContentColor = top_background,
                        unselectedContentColor = MaterialTheme.colorScheme.primary
                    )
                }
            }

}

