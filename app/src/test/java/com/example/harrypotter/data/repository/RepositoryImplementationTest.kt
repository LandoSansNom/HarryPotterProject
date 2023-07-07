package com.example.harrypotter.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.harrypotter.data.model.CharacterModel
import com.example.harrypotter.data.remote.harryPotterCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response
import java.util.ArrayList

class RepositoryImplementationTest
class RepositoryTest {

    // allow me to use the threads
    private val testDispatcher = StandardTestDispatcher()

    // allow me to run tasks on threads with priority
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var repository: Repository

    @Mock
    lateinit var harryPotterCall: harryPotterCall


    @Before
    fun startup() {
        MockitoAnnotations.openMocks(this) // initialize all the mocks that we have in THIS class
        Dispatchers.setMain(testDispatcher) // assume this as the main thread for testing

        repository = RepositoryImplementation(harryPotterCall)
    }

//    @After
//    fun clear() {
//        Mockito.clearAllCaches()
//    }

    @Test
    fun getAllCharcters_Success() = runTest {
        val mockResponse = ArrayList<CharacterModel>()
        mockResponse.add(CharacterModel(actor = "Cherlan-Miche"))
        // defining the API response in MOCK
        `when`(harryPotterCall.getAllCharcters()).thenReturn(mockResponse)

        val result = harryPotterCall.getAllCharcters()

        assertEquals(result.get(0).actor, mockResponse.get(0).actor)
    }

}