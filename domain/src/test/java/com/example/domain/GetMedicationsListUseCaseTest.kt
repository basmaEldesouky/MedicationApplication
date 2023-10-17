package com.example.domain

import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.example.common.Resource
import com.example.domain.repositoryContract.MedicationsListRepositoryContract
import com.example.domain.usecase.GetMedicationsListUseCase
import com.example.domain.utils.TestDataGenerator
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
@SmallTest
class GetMedicationsListUseCaseTest {
    @MockK
    private lateinit var repository: MedicationsListRepositoryContract

    private lateinit var getMedicationsListUseCase: GetMedicationsListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
        getMedicationsListUseCase = GetMedicationsListUseCase(repository)
    }

    @Test
    fun test_get_medications_list_success() = runBlockingTest {

        val medicationsList = TestDataGenerator.generateMedicationsList()
        val medicationsListFlow = flowOf(Resource.Success(medicationsList))

        // Given
        coEvery { repository.getMedicationsList() } returns medicationsListFlow

        // When & Assertions
        val result = getMedicationsListUseCase.invoke()
        result.test {
            // Expect Resource.Success
            val expected = expectItem()
            val expectedData = (expected as Resource.Success).data
            Truth.assertThat(expected).isInstanceOf(Resource.Success::class.java)
            Truth.assertThat(expectedData).isEqualTo(medicationsListFlow.first().data)
            expectComplete()
        }

        // Then
        coVerify { repository.getMedicationsList() }
    }


    @Test
    fun test_get_medications_list_fail() = runBlockingTest {

        val errorFlow = flowOf(Resource.Error(Exception()))

        // Given
        coEvery { repository.getMedicationsList() } returns errorFlow

        // When & Assertions
        val result = getMedicationsListUseCase.invoke()
        result.test {
            // Expect Resource.Error
            Truth.assertThat(expectItem()).isInstanceOf(Resource.Error::class.java)
            expectComplete()
        }

        // Then
        coVerify { repository.getMedicationsList() }
    }
}