package com.example.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.viewmodel.MedicationsListViewModel

@Composable
fun MedicationDetailsScreen(name: String?, dose: String?, strength: String?) {

    val viewModel: MedicationsListViewModel = hiltViewModel()
    //val medicine = viewModel.myMedicine.value
    //val medicine2 = viewModel.medicationsListData.collectAsState(initial = emptyList()).value

    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: $name", fontSize = 16.sp)
            Text(text = "Dose: $dose", fontSize = 16.sp)
            Text(text = "Strength: $strength", fontSize = 16.sp)
        }
    }
}