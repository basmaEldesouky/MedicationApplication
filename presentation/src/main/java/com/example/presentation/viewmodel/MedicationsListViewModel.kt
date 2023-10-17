package com.example.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.domain.entity.MedicationsListDataModel
import com.example.domain.usecase.GetMedicationsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class MedicationsListViewModel @Inject constructor(
    private val getMedicationsListUseCase: GetMedicationsListUseCase
) : ViewModel()  {

    private val _medicationsListData: MutableStateFlow<List<MedicationsListDataModel>?> = MutableStateFlow(null)
    var medicationsListData: StateFlow<List<MedicationsListDataModel>?> = _medicationsListData


    var myMedicine = mutableStateOf<MedicationsListDataModel?>(null)

    fun setMyMedicine(myObject: MedicationsListDataModel) {
        myMedicine.value = myObject
    }

    init {
        getMedicationsList()
    }

    fun getMedicationsList(){
        viewModelScope.launch{
            try {
                getMedicationsListUseCase.invoke()
                    .onStart { emit(Resource.Loading) }
                    .collect {
                        when (it) {
                            is Resource.Loading -> {}
                            is Resource.Success -> { _medicationsListData.value = it.data }
                            is Resource.Error -> {}
                            else -> {}
                        }
                    }
            } catch (e: Exception){ }
        }
    }
}