package com.example.domain.repositoryContract

import kotlinx.coroutines.flow.Flow
import com.example.common.Resource
import com.example.domain.entity.MedicationsListDataModel

interface MedicationsListRepositoryContract {
    suspend fun getMedicationsList(): Flow<Resource<List<MedicationsListDataModel>>>
}