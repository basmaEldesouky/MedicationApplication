package com.example.medicationapplication.di

import com.example.domain.repositoryContract.MedicationsListRepositoryContract
import com.example.domain.usecase.GetMedicationsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMedicationsListUseCase(
        medicationsListRepository: MedicationsListRepositoryContract,
    ): GetMedicationsListUseCase =
        GetMedicationsListUseCase(medicationsListRepository)

}