package com.example.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MedicationsList")
data class MedicationsListLocalEntity(
    @PrimaryKey
    var id: String,
    @ColumnInfo(name = "dose")
    var dose: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "strength")
    var strength: String
)