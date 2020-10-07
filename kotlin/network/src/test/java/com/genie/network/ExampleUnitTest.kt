package com.genie.network

import com.genie.network.model.request.LoginBody
import com.genie.network.model.respond.LoginResult
import okhttp3.internal.notify
import okhttp3.internal.wait
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.net.HttpURLConnection
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest {

    companion object {
        protected var server: MockWebServer? = null
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


    @Test
    fun addition_isCorrect() {
        server?.enqueue(
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                loadJSONFromAsset("login_success.json").toString()
            )
        )
        var lockObj = Any()
        val api: ApiService = ApiService.create(server?.url("/").toString())

        api.login(LoginBody("", ""))
            .subscribe { t1->
                val loginResult: LoginResult = t1?.data!!
                assertEquals(loginResult.userId, "12345")
                synchronized(lockObj) {
                    lockObj.notify()
                }
        }

        synchronized(lockObj) {
            lockObj.wait()
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
