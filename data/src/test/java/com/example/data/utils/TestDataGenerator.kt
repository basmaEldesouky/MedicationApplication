package com.example.data.utils

import com.example.data.local.MedicationsListLocalEntity
import com.example.domain.entity.MedicationsListDataModel

class TestDataGenerator {
    companion object{
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

        fun generateLocalMedicationsList(): List<MedicationsListLocalEntity> {
            return listOf(
                generateLocalMedicationItem(),
                generateLocalMedicationItem(),
                generateLocalMedicationItem()
            )
        }
        private fun generateLocalMedicationItem(): MedicationsListLocalEntity {
            return MedicationsListLocalEntity(
                id = "0",
                dose = "5gm",
                name = "asprin",
                strength = "strong"
            )
        }
    }
}