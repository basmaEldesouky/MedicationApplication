package com.example.data.repository

import com.example.common.Mapper
import com.example.common.Resource
import com.example.data.local.MedicationsListLocalDataSourceContract
import com.example.data.local.MedicationsListLocalEntity
import com.example.data.remote.MedicationsListRemoteDataSourceContract
import com.example.domain.entity.MedicationsListDataModel
import com.example.domain.repositoryContract.MedicationsListRepositoryContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MedicationsListRepositoryImp @Inject constructor(
    private val localDataSource: MedicationsListLocalDataSourceContract,
    private val remoteDataSource: MedicationsListRemoteDataSourceContract,
    private val medicationsListDataMapper: Mapper<MedicationsListDataModel, MedicationsListLocalEntity>,
): MedicationsListRepositoryContract {

    override suspend fun getMedicationsList(): Flow<Resource<List<MedicationsListDataModel>>> {
        return flow {
            try {
                // Get data from RemoteDataSource
                val data = remoteDataSource.getMedications()
                // Save to local
                localDataSource.insertMedicationsList(medicationsListDataMapper.fromList(data))
                // Emit data
                emit(Resource.Success(data))
            } catch (ex: Exception) {
                // If remote request fails
                try {
                    // Get data from LocalDataSource
                    val localData = localDataSource.getMedicationsListFromDataBase()
                    // Emit data
                    emit(Resource.Success(medicationsListDataMapper.toList(localData)))
                } catch (ex1: Exception) {
                    // Emit error
                    emit(Resource.Error(ex1))
                }
            }

        }
    }
}