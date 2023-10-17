package com.example.data.local

import javax.inject.Inject

class MedicationsListLocalDataSourceImp @Inject constructor(
    private val medicationsListDao: MedicationsListDao,
) : MedicationsListLocalDataSourceContract {

    override suspend fun getMedicationsListFromDataBase(): List<MedicationsListLocalEntity> {
        return medicationsListDao.getMedicationsList()
    }

    override suspend fun insertMedicationsList(data: List<MedicationsListLocalEntity>): List<Long> {
        return medicationsListDao.addMedications(data)
    }

    override suspend fun clearMedicationsListCashed(): Int {
        return medicationsListDao.clearMedicationsListCash()
    }
}