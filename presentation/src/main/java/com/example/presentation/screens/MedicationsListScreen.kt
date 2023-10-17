package com.example.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.presentation.components.MedicineCard
import com.example.presentation.viewmodel.MedicationsListViewModel
import java.util.Calendar
import androidx.navigation.NavHostController

@ExperimentalMaterial3Api
@Composable
fun MedicationsListScreen(navController : NavHostController = rememberNavController(),
                          name: String,
) {

    var userName by remember { mutableStateOf(name) }
    val viewModel: MedicationsListViewModel = hiltViewModel()
    val medicines = viewModel.medicationsListData.collectAsState(initial = emptyList()).value

    val currentTime = rememberUpdatedState(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
    val isMorning = currentTime.value in 0..11
    val greeting = if (isMorning) "Good Morning" else "Good Evening"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "$greeting, $userName!",
            modifier = Modifier.padding(bottom = 16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            medicines?.forEach { medicine ->
                MedicineCard(navController, medicine)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}