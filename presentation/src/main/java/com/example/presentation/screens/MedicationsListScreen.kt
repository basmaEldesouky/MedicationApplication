package com.example.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.domain.entity.MedicationsListDataModel
import com.example.presentation.components.MedicineCard
import java.util.Calendar

@ExperimentalMaterial3Api
@Composable
fun MedicationsListScreen(navController : NavHostController = rememberNavController(), name: String) {

    var userName by remember { mutableStateOf(name) }
    var medicines by remember { mutableStateOf(emptyList<MedicationsListDataModel>()) }

    val currentTime = rememberUpdatedState(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
    val isMorning = currentTime.value in 0..11
    val greeting = if (isMorning) "Good Morning" else "Good Evening"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "$greeting, $userName",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        BasicTextField(
            value = userName,
            onValueChange = { userName = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = TextStyle(fontSize = 20.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Medicine Cards
        Column {
            medicines.forEach { medicine ->
                MedicineCard(navController, medicine)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}