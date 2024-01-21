package com.furkanakak.whatsappcloneapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.furkanakak.whatsappcloneapp.navigation.NavGraph
import com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.ChildViewEnum
import com.furkanakak.whatsappcloneapp.ui.theme.WhatsappCloneAppTheme
import com.furkanakak.whatsappcloneapp.ui.theme.md_theme_dark2_surface
import com.furkanakak.whatsappcloneapp.ui.theme.md_theme_dark_surface
import com.furkanakak.whatsappcloneapp.ui.theme.soft_white
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val navController = rememberNavController()
            var isExpanded by remember { mutableStateOf(false) }
            var isFabIcon by remember { mutableStateOf(Icons.Filled.Chat) }
            var isFabVisibility by remember { mutableStateOf(false) }




            WhatsappCloneAppTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavGraph(navController = navController, childViewCallback = { value ->
                            Log.v("childView", "$value")
                            fabManagement(
                                value,
                                setExpanded = { isExpanded = it },
                                setFabIcon = { isFabIcon = it },
                                setFabVisibility = { isFabVisibility = it })

                        })
                    }

                    if (isFabVisibility) {
                        ExpandableFab(
                            isExpanded = isExpanded,
                            isFabIcon = isFabIcon,
                            isFabVisibility = isFabVisibility,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp)
                        )
                    }


                }

            }
        }
    }

    private fun fabManagement(
        value: String,
        setExpanded: (Boolean) -> Unit,
        setFabIcon: (ImageVector) -> Unit,
        setFabVisibility: (Boolean) -> Unit
    ) {

        when (value) {
            ChildViewEnum.Chats.value -> {
                setExpanded(false)
                setFabIcon(Icons.Filled.Chat)
                setFabVisibility(true)
            }

            ChildViewEnum.Status.value -> {
                setExpanded(true)
                setFabIcon(Icons.Filled.CameraAlt)
                setFabVisibility(true)
            }

            ChildViewEnum.Calls.value -> {
                setExpanded(false)
                setFabIcon(Icons.Filled.Call)
                setFabVisibility(true)
            }

            ChildViewEnum.None.value -> {
                setExpanded(false)
                setFabIcon(Icons.Filled.Chat)
                setFabVisibility(false)
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsappCloneAppTheme {
        Greeting("Android")
    }
}

@Composable
fun ExpandableFab(
    isExpanded: Boolean,
    isFabIcon: ImageVector,
    isFabVisibility: Boolean,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .animateContentSize()
            .background(Color.Transparent)
    ) {
        if (isExpanded) {
            FloatingActionButton(
                onClick = {

                },
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.size(45.dp)
            )
            {
                Icon(
                    Icons.Filled.Edit, contentDescription = "Child FAB",
                    modifier = Modifier.background(Color.Transparent),
                    tint = soft_white
                )
            }

        }

        FloatingActionButton(
            onClick = {
            },
            containerColor = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.size(55.dp)
        ) {
            Icon(
                imageVector = isFabIcon,
                contentDescription = "Main FAB",
                modifier = Modifier.background(Color.Transparent),
                tint = md_theme_dark_surface
            )
        }


    }


}
