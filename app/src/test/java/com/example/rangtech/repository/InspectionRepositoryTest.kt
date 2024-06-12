package com.example.rangtech.repository

import com.example.rangtech.db.InspectionDao
import com.example.rangtech.models.AnswerChoice
import com.example.rangtech.models.Area
import com.example.rangtech.models.Category
import com.example.rangtech.models.Inspection
import com.example.rangtech.models.InspectionType
import com.example.rangtech.models.Question
import com.example.rangtech.models.Survey
import com.example.rangtech.models.User
import com.example.rangtech.network.ApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest

@ExperimentalCoroutinesApi
class InspectionRepositoryTest {

    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var inspectionDao: InspectionDao

    private lateinit var repository: InspectionRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = InspectionRepository(apiService, inspectionDao)
    }

    @Test
    fun `register success`() = runTest {
        // Setup
        val user = User("test@example.com", "password")
        Mockito.`when`(apiService.register(user)).thenReturn(Response.success(Unit))

        // Test
        val response = repository.register(user)

        // Assert
        assert(response.isSuccessful)
    }

    @Test
    fun `login success`() = runTest {
        // Setup
        val user = User("test@example.com", "password")
        Mockito.`when`(apiService.login(user)).thenReturn(Response.success(Unit))

        // Test
        val response = repository.login(user)

        // Assert
        assert(response.isSuccessful)
    }

    @Test
    fun `start inspection success`() = runTest {
        // Setup
        val inspection = Inspection(
            id = 1,
            inspectionType = InspectionType(1, "Clinical", "write"),
            area = Area(1, "Emergency ICU"),
            survey = Survey(
                id = 1,
                categories = listOf(
                    Category(
                        id = 1,
                        name = "Drugs",
                        questions = listOf(
                            Question(
                                id = 1,
                                name = "Is the drugs trolley locked?",
                                answerChoices = listOf(
                                    AnswerChoice(1, "Yes", 1.0),
                                    AnswerChoice(2, "No", 0.0)
                                ),
                                selectedAnswerChoiceId = 1
                            )
                        )
                    )
                )
            )
        )
        Mockito.`when`(apiService.startInspection()).thenReturn(Response.success(inspection))

        // Test
        val result = repository.startInspection()

        // Assert
        assert(result == inspection)
    }

    @Test
    fun `submit inspection success`() = runTest {
        // Setup
        val inspection = Inspection(
            id = 1,
            inspectionType = InspectionType(1, "Clinical", "write"),
            area = Area(1, "Emergency ICU"),
            survey = Survey(
                id = 1,
                categories = listOf(
                    Category(
                        id = 1,
                        name = "Drugs",
                        questions = listOf(
                            Question(
                                id = 1,
                                name = "Is the drugs trolley locked?",
                                answerChoices = listOf(
                                    AnswerChoice(1, "Yes", 1.0),
                                    AnswerChoice(2, "No", 0.0)
                                ),
                                selectedAnswerChoiceId = 1
                            )
                        )
                    )
                )
            )
        )
        Mockito.`when`(apiService.submitInspection(inspection)).thenReturn(Response.success(Unit))

        // Test
        val success = repository.submitInspection(inspection)

        // Assert
        assert(success)
    }
}
