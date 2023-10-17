package com.example.data.remote

import com.example.domain.entity.MedicationsListDataModel
import javax.inject.Inject

class MedicationsListRemoteDataSourceImp @Inject constructor(
    private val apiService: MedicationsListRemoteServices
) : MedicationsListRemoteDataSourceContract {

    override suspend fun getMedications(): List<MedicationsListDataModel> {
        return apiService.getMedicationsList()
    }
}