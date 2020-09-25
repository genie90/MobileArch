package com.genie.network.model

import com.genie.domain.entity.UserEntity
import com.genie.domain.entity.WrapperEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.network.ApiService
import com.genie.network.model.request.LoginBody
import com.genie.network.model.respond.LoginResult
import com.genie.network.model.respond.WrapperRespond
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
class AuthNetwork(apiService: ApiService): AuthInterface {

    private val authService: ApiService = apiService

    override fun signUpWithPhone(phone: String): Any {
        return Any()
    }

    override fun signInWithPhoneAndPassword(
        phone: String?,
        password: String?
    ): Single<WrapperEntity<UserEntity>> {

        return Single.create<WrapperEntity<UserEntity>> {
            authService.login(LoginBody(phone, password)).enqueue(object :Callback<WrapperRespond<LoginResult>>{
                override fun onFailure(call: Call<WrapperRespond<LoginResult>>, t: Throwable) {
                    it.onError(t)
                }

                override fun onResponse(call: Call<WrapperRespond<LoginResult>>, response: Response<WrapperRespond<LoginResult>>) {
                    val loginResult: LoginResult? = response.body()?.data
                    if (loginResult != null) {
                        it.onSuccess(WrapperEntity(
                            UserEntity(
                                userId = loginResult.userId, phone = loginResult.phone, email = loginResult.email
                            ), null, code = 200))
                    }

                }

            })
        }

//
//        authService.login(LoginBody(phone, password)).enqueue(object :Callback<WrapperRespond<LoginResult>>{
//            override fun onFailure(call: Call<WrapperRespond<LoginResult>>, t: Throwable) {
//                result.value = WrapperEntity(null, throwable = t, code = 1001)
//            }
//
//            override fun onResponse(call: Call<WrapperRespond<LoginResult>>, response: Response<WrapperRespond<LoginResult>>) {
//                val loginResult: LoginResult? = response.body()?.data
//                if (loginResult != null) {
//                    result.value = WrapperEntity(
//                        UserEntity(
//                            userId = loginResult.userId, phone = loginResult.phone, email = loginResult.email
//                        ), null, code = 200)
//                }
//
//            }
//
//        })
//
//        return result
    }
}