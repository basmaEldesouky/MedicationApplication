package com.example.domain.entity

import java.io.Serializable

data class MedicationsListDataModel(
    var id: String,
    var dose: String,
    var name: String,
    var strength: String
): Serializable