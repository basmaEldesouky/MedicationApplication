package com.example.medicationapplication

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.presentation.screens.LoginScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun setUpNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController ,
        startDestination = "login"
    ){

        composable("login") {
            LoginScreen()
        }
        composable("medications_list",
            arguments = listOf(navArgument("name") { type = NavType.StringType }))
        {
                backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            //MedicationsListScreen(name = name)
        }
        composable("medication_details") {
           // MedicationDetailsScreen()
        }
    }

}