package com.example.data.repository

import com.example.common.Mapper
import com.example.data.local.MedicationsListLocalEntity
import com.example.domain.entity.MedicationsListDataModel
import javax.inject.Inject

class MedicationsListDataMapper @Inject constructor() :
    Mapper<MedicationsListDataModel, MedicationsListLocalEntity> {

    override fun from(i: MedicationsListDataModel?): MedicationsListLocalEntity {
        return MedicationsListLocalEntity(
            id = i?.id ?: "",
            dose = i?.dose ?: "",
            name = i?.name ?: "",
            strength = i?.strength ?: ""
        )
    }

    override fun to(o: MedicationsListLocalEntity?): MedicationsListDataModel {
        return MedicationsListDataModel(
            id = o?.id ?: "",
            dose = o?.dose ?: "",
            name = o?.name ?: "",
            strength = o?.strength ?: ""
        )
    }
}