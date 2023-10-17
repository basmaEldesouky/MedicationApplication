package com.example.medicationapplication.di

import com.example.common.Mapper
import com.example.data.local.MedicationsListDao
import com.example.data.local.MedicationsListLocalDataSourceImp
import com.example.data.local.MedicationsListLocalEntity
import com.example.data.remote.MedicationsListRemoteDataSourceImp
import com.example.data.remote.MedicationsListRemoteServices
import com.example.data.repository.MedicationsListRepositoryImp
import com.example.domain.entity.MedicationsListDataModel
import com.example.domain.repositoryContract.MedicationsListRepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMedicationsListLocalDataSource(
        medicationsListDao: MedicationsListDao,
    ) = MedicationsListLocalDataSourceImp(medicationsListDao)

    @Singleton
    @Provides
    fun provideMedicationsListRemoteDataSource(
        apiService: MedicationsListRemoteServices,
    ) = MedicationsListRemoteDataSourceImp(
        apiService
    )

    @Singleton
    @Provides
    fun provideMedicationsListRepository(
        localDataSource: MedicationsListLocalDataSourceImp,
        remoteDataSource: MedicationsListRemoteDataSourceImp,
        mapper: Mapper<MedicationsListDataModel, MedicationsListLocalEntity>
    ): MedicationsListRepositoryContract =
        MedicationsListRepositoryImp(
            localDataSource,
            remoteDataSource,
            mapper
        )
}