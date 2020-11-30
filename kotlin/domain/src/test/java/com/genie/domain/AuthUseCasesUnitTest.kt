package com.genie.domain

import com.genie.domain.entity.UserEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.domain.usecase.AuthUseCases
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AuthUseCasesUnitTest {
    private lateinit var authUseCases: AuthUseCases
    private val lockObj = Object()


    @Before
    fun init() {

        authUseCases = AuthUseCases(object : AuthInterface {
            override fun signUpWithPhone(phone: String): Any {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun signInWithPhoneAndPassword(
                phone: String?,
                password: String?
            ): Single<UserEntity> {
                return Single.create { emitter ->
                    Thread().run {
                        Thread.sleep(2000)
                        emitter.onSuccess(
                            UserEntity(
                                "12345",
                                "+841212332123",
                                "viet.tr90@gmail.com"
                            )
                        )
                    }
                }
            }
        })
    }

    @Test
    fun authUseCases_doLoginSuccess() {

        authUseCases.doLogin("", "")
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.computation())
            .doOnError {
                System.out.println("error")
            }
            .doOnSuccess { loginResult ->
                assertEquals(loginResult.userId, "12345")
                assertEquals(loginResult.email, "viet.tr90@gmail.com")
                assertEquals(loginResult.phone, "+841212332123")
                synchronized(lockObj) {
                    lockObj.notify()
                }
            }
            .subscribe()

        synchronized(lockObj) {
            lockObj.wait()
        }
    }
}
