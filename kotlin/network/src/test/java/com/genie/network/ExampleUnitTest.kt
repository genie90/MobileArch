package com.genie.network

import com.genie.network.model.request.LoginBody
import com.genie.network.model.respond.LoginResult
import com.genie.network.model.respond.WrapperRespond
import okhttp3.internal.notify
import okhttp3.internal.wait
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    val api: ApiService = ApiService.create(server?.url("/").toString())

    @Test
    fun addition_isCorrect() {
        server?.enqueue(
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                loadJSONFromAsset("login_success.json").toString()
            )
        )
        var lockObj = Any()


        api.login(LoginBody("", "")).enqueue(object : Callback<WrapperRespond<LoginResult>> {
            override fun onFailure(call: Call<WrapperRespond<LoginResult>>, t: Throwable) {
                assertTrue(false)
            }

            override fun onResponse(
                call: Call<WrapperRespond<LoginResult>>,
                response: Response<WrapperRespond<LoginResult>>
            ) {
                val loginResult: LoginResult = response.body()?.data!!
                assertEquals(loginResult.userId, "12345")
                synchronized(lockObj) {
                    lockObj.notify()
                }
            }

        })
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
