package com.nomadworks.spacez.launch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nomadworks.spacez.common.api.model.launch.Launch
import com.nomadworks.spacez.common.repository.SpacexRepository
import com.nomadworks.spacez.launch.domain.GetLatestLaunchUseCase
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.File


class LaunchInfoViewModelTest {
    @Suppress("unused")
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    var coroutineDispatcher = TestCoroutineDispatcher()

    lateinit var SUT: LaunchInfoViewModel

    @Mock
    lateinit var repository: SpacexRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        Dispatchers.setMain(coroutineDispatcher)
        MockitoAnnotations.openMocks(this)
        SUT = LaunchInfoViewModel((GetLatestLaunchUseCase(repository)))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        coroutineDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun requestLaunchInfo_success_return_launch() {
        runBlocking {
            `when`(repository.fetchLatestLaunch()).thenReturn(getLatestLaunchResult())

            SUT.requestLaunchInfo()

            val viewState = SUT.viewState.value!!

            assertEquals(false, viewState.showWait)
            assertEquals(LAUNCH_DETAILS, viewState.launchInfo)
            assertEquals(NAME, viewState.launchName)
            assertEquals(IMAGE_LINK, viewState.launchImageLink)
            assertEquals(PATCH_IMAGE_LINK, viewState.patchImageLink)
        }
    }

    private fun getLatestLaunchResult(): Launch {
        val jsonAdapter: JsonAdapter<Launch> = Moshi.Builder().build().adapter(Launch::class.java)
        return jsonAdapter.fromJson(
            File("src/test/resources/json/latest-launch.json").source().buffer()
        )!!
    }

    companion object {
        private const val LAUNCH_DETAILS = "This mission launches the sixteenth batch of operational Starlink satellites, which are version 1.0, from LC-39A. It is the eighteenth Starlink launch overall. The satellites will be delivered to low Earth orbit and will spend a few weeks maneuvering to their operational altitude. The booster is expected to land on an ASDS."
        private const val NAME = "Starlink-17 (v1.0)"
        private const val IMAGE_LINK = "https://live.staticflickr.com/65535/51004598206_9779f08338_o.jpg"
        private const val PATCH_IMAGE_LINK = "https://imgur.com/BrW201S.png"
    }
}