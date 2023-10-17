package com.example.data

import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.example.common.Resource
import com.example.data.local.MedicationsListLocalDataSourceContract
import com.example.data.remote.MedicationsListRemoteDataSourceContract
import com.example.data.repository.MedicationsListDataMapper
import com.example.data.repository.MedicationsListRepositoryImp
import com.example.data.utils.TestDataGenerator
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
@SmallTest
class RepositoryImpTest {

    @MockK
    private lateinit var localDataSource: MedicationsListLocalDataSourceContract

    @MockK
    private lateinit var remoteDataSource: MedicationsListRemoteDataSourceContract

    private val medicationsListDataMapper = MedicationsListDataMapper()

    private lateinit var repository: MedicationsListRepositoryImp

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
        // Create RepositoryImp before every test
        repository = MedicationsListRepositoryImp(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource,
            medicationsListDataMapper = medicationsListDataMapper,
        )
    }

    @Test
    fun test_get_medications_from_remote_success() = runBlockingTest {

        val medications = TestDataGenerator.generateMedicationsList()
        val affectedIds = MutableList(medications.size) { index -> index.toLong() }

        // Given
        coEvery { remoteDataSource.getMedications() } returns medications
        coEvery { localDataSource.insertMedicationsList(medicationsListDataMapper.fromList(medications)) } returns affectedIds
        coEvery { localDataSource.getMedicationsListFromDataBase() } returns medicationsListDataMapper.fromList(medications)

        // When & Assertions
        val flow = repository.getMedicationsList()
        flow.test {
            // Expect Resource.Success
            val expected = expectItem()
            val expectedData = (expected as Resource.Success).data
            Truth.assertThat(expected).isInstanceOf(Resource.Success::class.java)
            Truth.assertThat(expectedData[0].id).isEqualTo(medications[0].id)
            expectComplete()
        }

        // Then
        coVerify { remoteDataSource.getMedications() }
        coVerify { localDataSource.insertMedicationsList(medicationsListDataMapper.fromList(medications)) }
    }

    @Test
    fun test_get_medications_from_local_when_remote_fail() = runBlockingTest {

        val medications = TestDataGenerator.generateMedicationsList()

        // Given
        coEvery { remoteDataSource.getMedications() } throws Exception()
        coEvery { localDataSource.getMedicationsListFromDataBase() } returns medicationsListDataMapper.fromList(medications)

        // When && Assertions
        val flow = repository.getMedicationsList()
        flow.test {
            // Expect Resource.Success
            val expected = expectItem()
            val expectedData = (expected as Resource.Success).data
            Truth.assertThat(expected).isInstanceOf(Resource.Success::class.java)
            Truth.assertThat(expectedData[0].id).isEqualTo(medications[0].id)
            expectComplete()
        }

        // Then
        coVerify { remoteDataSource.getMedications() }
        coVerify { localDataSource.getMedicationsListFromDataBase() }

    }

    @Test
    fun test_for_error_state_when_remote_and_local_fail_of_getting_medications() = runBlockingTest {
        // Given
        coEvery { remoteDataSource.getMedications() } throws Exception()
        coEvery { localDataSource.getMedicationsListFromDataBase() } throws Exception()

        // When && Assertions
        val flow = repository.getMedicationsList()
        flow.test {
            // Expect Resource.Error
            Truth.assertThat(expectItem()).isInstanceOf(Resource.Error::class.java)
            expectComplete()
        }

        // Then
        coVerify { remoteDataSource.getMedications() }
        coVerify { localDataSource.getMedicationsListFromDataBase() }

    }
}