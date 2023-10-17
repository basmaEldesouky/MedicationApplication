package com.example.domain.utils

import com.example.domain.entity.MedicationsListDataModel

class TestDataGenerator {
    companion object {
        fun generateMedicationsList(): List<MedicationsListDataModel> {
            return listOf(
                generateMedicationItem(),
                generateMedicationItem(),
                generateMedicationItem()
            )
        }
        private fun generateMedicationItem(): MedicationsListDataModel {
            return MedicationsListDataModel(
                id = "0",
                dose = "5gm",
                name = "asprin",
                strength = "strong"
            )
        }
    }
}