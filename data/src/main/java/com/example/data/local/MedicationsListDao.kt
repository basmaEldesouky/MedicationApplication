package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicationsListDao {
    @Query("select * from MedicationsList")
    fun getMedicationsList(): List<MedicationsListLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMedications(medications: List<MedicationsListLocalEntity>): List<Long>

    @Query("delete from MedicationsList")
    fun clearMedicationsListCash():Int
}