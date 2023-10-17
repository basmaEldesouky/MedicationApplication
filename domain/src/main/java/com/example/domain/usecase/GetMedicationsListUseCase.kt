package com.example.domain.usecase

import com.example.common.Resource
import com.example.domain.entity.MedicationsListDataModel
import com.example.domain.repositoryContract.MedicationsListRepositoryContract
import kotlinx.coroutines.flow.Flow

class GetMedicationsListUseCase(private val repositoryContract: MedicationsListRepositoryContract) {
    suspend fun invoke(): Flow<Resource<List<MedicationsListDataModel>>> {
        return repositoryContract.getMedicationsList()
    }
}