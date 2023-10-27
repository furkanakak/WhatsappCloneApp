package com.furkanakak.whatsappcloneapp.common.extension

import android.util.Log
import androidx.navigation.NavDestination
import com.furkanakak.whatsappcloneapp.navigation.Screen

fun  NavDestination?.topBarVisibility() =
    if (this?.route?.contains(Screen.ChatScreen.route) == true){
        Log.v("deneme","if -> ${Screen.ChatScreen.route}")
        false
    }
else{
        Log.v("deneme","else -> ${Screen.ChatScreen.route}")
    true
    }

