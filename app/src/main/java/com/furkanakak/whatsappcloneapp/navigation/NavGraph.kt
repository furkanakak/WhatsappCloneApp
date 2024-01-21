package com.furkanakak.whatsappcloneapp.navigation

import android.os.Build
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.furkanakak.whatsappcloneapp.screen.chatscreen.ChatScreen
import com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.ChildViewEnum
import com.furkanakak.whatsappcloneapp.screen.mainscreen.main_pager_screen.MainScreen
import com.furkanakak.whatsappcloneapp.screen.profile_screen.ProfileScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController,childViewCallback : (String) -> Unit) {

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){

        composable(route = Screen.MainScreen.route) {
            MainScreen(navigateToChatScreen = { id ->
                childViewCallback(ChildViewEnum.None.value)
                navController.navigate("${Screen.ChatScreen.route}/$id")
            },childView = { childView ->
                childViewCallback(childView)
            })
        }

        composable(route = "${ Screen.ChatScreen.route }/{id}",arguments = listOf(navArgument("id") { type = NavType.IntType })) {
            ChatScreen(id = it.arguments?.getInt("id")?:-1, popBackStack = {
                childViewCallback(ChildViewEnum.Chats.value)
                navController.popBackStack()
            }, navigateToProfile = { selectedProfile ->
                val selectedProfileJson = Json.encodeToString(selectedProfile)
                val selectedProfileBase64 = Base64.encodeToString(selectedProfileJson.toByteArray(), Base64.NO_WRAP)
                Log.v("profile2","$selectedProfile")
                navController.navigate("${Screen.ProfileScreen.route}/$selectedProfileBase64")
            })
        }

        composable(route = "${Screen.ProfileScreen.route }/{selectedProfile}", arguments = listOf(navArgument("selectedProfile"){type = NavType.StringType})) {
            ProfileScreen(selectedProfile = it.arguments?.getString("selectedProfile"), onBackClick = {
                navController.popBackStack()
            })
        }



    }
}