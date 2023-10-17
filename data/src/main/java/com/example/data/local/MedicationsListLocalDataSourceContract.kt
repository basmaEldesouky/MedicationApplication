package com.example.data.local

interface MedicationsListLocalDataSourceContract {

    suspend fun getMedicationsListFromDataBase(): List<MedicationsListLocalEntity>

    suspend fun insertMedicationsList(data: List<MedicationsListLocalEntity>): List<Long>

    suspend fun clearMedicationsListCashed(): Int
}