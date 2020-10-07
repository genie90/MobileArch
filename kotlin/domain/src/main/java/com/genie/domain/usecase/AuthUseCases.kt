package com.genie.domain.usecase

import com.genie.domain.entity.UserEntity
import com.genie.domain.interfaces.AuthInterface
import io.reactivex.rxjava3.core.Single

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
class AuthUseCases(authInterface: AuthInterface) {
    val auth: AuthInterface = authInterface

    fun doLogin(phone: String?, pass: String?): Single<UserEntity> {
        return auth.signInWithPhoneAndPassword(phone, pass)
    }


}