package com.genie.network

import com.genie.network.model.request.LoginBody
import com.genie.network.model.respond.LoginResult
import okhttp3.internal.notify
import okhttp3.internal.wait
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.net.HttpURLConnection

/**
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class AuthNetworkTest: BaseNetworkTest() {

    private lateinit var api: ApiService
    private val lockObj = Any()

    @Before
    fun init() {
        api = ApiService.create(server?.url("/").toString())

    }

    @Test
    fun loginSuccessGetRespondTest() {
        server?.enqueue(
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                loadJSONFromAsset("login_success.json").toString()
            )
        )

        api.login(LoginBody("", ""))
            .subscribe { t1->
                val loginResult: LoginResult = t1?.data!!
                assertEquals(loginResult.userId, "12345")
                assertEquals(loginResult.email, "viet.tr90@gmail.com")
                assertEquals(loginResult.phone, "+841212332123")
                synchronized(lockObj) {
                    lockObj.notify()
                }
        }

        synchronized(lockObj) {
            lockObj.wait()
        }
    }

}
