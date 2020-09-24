package com.genie.mvvm_clean_flowcoor.usecase

import androidx.lifecycle.LiveData
import com.genie.domain.entity.UserEntity
import com.genie.domain.entity.WrapperEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.domain.usecase.AuthUseCases
import com.genie.network.ApiService
import com.genie.network.model.AuthNetwork

/**
 * Created by viet.tr90@gmail.com on 24/9/20.
 */
object AuthUseCaseProvider {

    private val authImpl: AuthInterface = AuthNetwork(ApiService.create())

    fun login(phone: String?, password: String?): LiveData<WrapperEntity<UserEntity>> {
        return AuthUseCases(authImpl).doLogin(phone, password)
    }
}