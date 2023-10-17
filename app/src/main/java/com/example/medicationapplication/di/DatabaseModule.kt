package com.example.medicationapplication.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.MedicationsListLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideMedicationsListDatabase(@ApplicationContext application: Context): MedicationsListLocalDatabase {
        return Room
            .databaseBuilder(application, MedicationsListLocalDatabase::class.java, "medications_list_database")
            .build()
    }
    @Provides
    @Singleton
    fun provideMedicationsListDao(medicationsListDataBase: MedicationsListLocalDatabase) =
        medicationsListDataBase.medicationsListDao()

}