package com.genie.network.model

import com.genie.domain.entity.UserEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.network.ApiService
import com.genie.network.model.request.LoginBody
import io.reactivex.rxjava3.core.Single
import java.net.HttpURLConnection.HTTP_OK

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
class AuthNetwork(apiService: ApiService) : AuthInterface {

    private val authService: ApiService = apiService

    override fun signUpWithPhone(phone: String): Any {
        return Any()
    }

    override fun signInWithPhoneAndPassword(
        phone: String?,
        password: String?
    ): Single<UserEntity> {

        return authService.login(LoginBody(phone, password)).map {
                UserEntity(
                    userId = it.data!!.userId, phone = it.data!!.phone, email = it.data!!.email
                )
        }
    }
}