package com.genie.network.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.genie.domain.entity.UserEntity
import com.genie.domain.entity.WrapperEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.network.ApiService
import com.genie.network.model.request.LoginBody
import com.genie.network.model.request.SignUpBody
import com.genie.network.model.respond.LoginResult
import com.genie.network.model.respond.SignUpResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
class AuthNetwork(apiService: ApiService): AuthInterface {

    private val authService: ApiService = apiService

    override fun signUpWithPhone(phone: String): Any {
        val result: MutableLiveData<WrapperEntity<UserEntity>> = MutableLiveData()
        authService.signUp(SignUpBody(phone)).enqueue(object :Callback<SignUpResult>{
            override fun onFailure(call: Call<SignUpResult>, t: Throwable) {
                result.value = WrapperEntity(null, throwable = t, code = 1001)
            }

            override fun onResponse(call: Call<SignUpResult>, response: Response<SignUpResult>) {
                result.value = WrapperEntity(
                    UserEntity(
                    id = 1, phone = "+844567654567", email = "viet.tr90@gmail.com"
                ), null, code = response.code())
            }

        })

        return result
    }

    override fun signInWithPhoneAndPassword(
        phone: String?,
        password: String?
    ): LiveData<WrapperEntity<UserEntity>> {
        val result: MutableLiveData<WrapperEntity<UserEntity>> = MutableLiveData()

        authService.login(LoginBody(phone, password)).enqueue(object :Callback<LoginResult>{
            override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                result.value = WrapperEntity(null, throwable = t, code = 1001)
            }

            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                result.value = WrapperEntity(
                    UserEntity(
                        id = 1, phone = "+844567654567", email = "viet.tr90@gmail.com"
                    ), null, code = 200)
//                result.value = WrapperEntity( dxo here to convert )

            }

        })

        return result
    }
}