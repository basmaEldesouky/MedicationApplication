package com.example.data.remote

import com.example.domain.entity.MedicationsListDataModel
import retrofit2.http.GET

interface MedicationsListRemoteServices {
    @GET("ae289d2d-a032-4d1c-876b-63127acaa2bd")
    suspend fun getMedicationsList(): List<MedicationsListDataModel>
}