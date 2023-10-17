package com.example.medicationapplication.di

import com.example.common.Mapper
import com.example.data.local.MedicationsListLocalEntity
import com.example.data.repository.MedicationsListDataMapper
import com.example.domain.entity.MedicationsListDataModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    @Binds
    abstract fun bindsLocalMedicationsListDataMapperMapper(mapper: MedicationsListDataMapper): Mapper<MedicationsListDataModel, MedicationsListLocalEntity>
}