package com.genie.repository.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.genie.domain.entity.UserEntity
import com.genie.domain.interfaces.AuthInterface
import com.genie.domain.usecase.AuthUseCases

/**
 * Created by genie@gobear.com on 7/10/20.
 */
object AuthRepository {

    private val authImpl: AuthInterface = NetworkProvider.getAuthMethod(NetworkProvider.AvailableNetwork.REST_API)

    fun login(phone: String?, password: String?): LiveData<UserEntity> {

        var respond: MutableLiveData<UserEntity> = MutableLiveData()
        AuthUseCases(authImpl).doLogin(phone, password).subscribe { result: UserEntity?, t: Throwable? ->
            if (t != null) {
                // error
                return@subscribe
            }
            respond.value = result
        }
        return respond
    }

}