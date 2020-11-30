package com.genie.network

import okhttp3.mockwebserver.MockWebServer
import org.junit.AfterClass
import org.junit.BeforeClass
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

/**
 * Created by viet.tr90@gmail.com on 12/10/20.
 */
open class BaseNetworkTest {
    companion object {
        var server: MockWebServer? = null
        @BeforeClass
        @JvmStatic
        fun setUpServer() {
            try {
                server = MockWebServer()
                server?.start(5890)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        @AfterClass
        @JvmStatic
        fun shutdownServer() {
            try {
                server?.shutdown()
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadJSONFromAsset(
        jsonFileName: String?
    ): String? {

        val loader = ClassLoader.getSystemClassLoader()

        return Files.lines(Paths.get(loader.getResource(jsonFileName).toURI()))
            .parallel()
            .collect(Collectors.joining())
    }

}