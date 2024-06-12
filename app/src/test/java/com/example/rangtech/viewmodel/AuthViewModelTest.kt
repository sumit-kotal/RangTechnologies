package com.example.rangtech.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rangtech.models.User
import com.example.rangtech.repository.InspectionRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class AuthViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: InspectionRepository

    private lateinit var viewModel: AuthViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = AuthViewModel(repository)
    }

    @Test
    fun `login success`() = runTest {
        // Setup
        val email = "test@example.com"
        val password = "password"
        Mockito.`when`(repository.login(User(email, password)))
            .thenReturn(Response.success(Unit))

        // Test
        viewModel.login(email, password)

        // Assert
        assert(viewModel.loginState.value?.isSuccess == true)
    }

    @Test
    fun `login failure`() = runTest {
        // Setup
        val email = "test@example.com"
        val password = "password"
        Mockito.`when`(repository.login(User(email, password)))
            .thenReturn(Response.error(401, "".toResponseBody()))

        // Test
        viewModel.login(email, password)

        // Assert
        assert(viewModel.loginState.value?.isFailure == true)
    }
}
