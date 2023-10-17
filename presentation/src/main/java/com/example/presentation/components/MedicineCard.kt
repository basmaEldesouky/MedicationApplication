package com.example.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.domain.entity.MedicationsListDataModel
import com.example.presentation.viewmodel.MedicationsListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineCard(navController : NavHostController = rememberNavController(), medicine: MedicationsListDataModel) {

    val viewModel: MedicationsListViewModel = hiltViewModel()
    //val medicines = viewModel.medicationsListData.collectAsState(initial = emptyList()).value

    Card(
        onClick = {
            viewModel.setMyMedicine(medicine)
            navController.navigate("medication_details")
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: ${medicine.name}", fontSize = 18.sp)
            Text(text = "Dose: ${medicine.dose}", fontSize = 16.sp)
            Text(text = "Strength: ${medicine.strength}", fontSize = 16.sp)
        }
    }
}