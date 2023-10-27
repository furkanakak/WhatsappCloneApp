package com.furkanakak.whatsappcloneapp.navigation

sealed class Screen(val route : String)  {
    object MainScreen : Screen("MainScreen")
    object ChatScreen : Screen("ChatScreen")
    object ProfileScreen : Screen("ProfileScreen")

}