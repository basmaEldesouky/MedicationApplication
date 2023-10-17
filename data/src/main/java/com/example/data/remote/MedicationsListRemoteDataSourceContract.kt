package com.example.data.remote

import com.example.domain.entity.MedicationsListDataModel

interface MedicationsListRemoteDataSourceContract {
    suspend fun getMedications (): List<MedicationsListDataModel>
}