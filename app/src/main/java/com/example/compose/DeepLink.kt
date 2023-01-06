package com.example.compose

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

@Composable
fun DeepLink(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        navController.navigate(route = "details")
                    }
                ) {
                    Text(text = "Go to Details")
                }
            }
        }

        composable(
            route = "details",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://sukajeetech.com/{id}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { entry ->
            val id = entry.arguments?.getInt("id")
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Detail Screen: Id is : $id", fontSize = 30.sp)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DeepLinkPreview() {
    DeepLink()
}