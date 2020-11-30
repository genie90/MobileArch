package com.genie.repository.auth

import com.genie.domain.entity.UserEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.domain.usecase.AuthUseCases
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by viet.tr90@gmail.com on 7/10/20.
 */
class AuthRepository @Inject constructor() {

    private val authImpl: AuthInterface =
        NetworkProvider.getAuthMethod(NetworkProvider.AvailableNetwork.REST_API)

    fun login(phone: String?, password: String?): Single<UserEntity> {
        return AuthUseCases(authImpl).doLogin(phone, password)
    }

}