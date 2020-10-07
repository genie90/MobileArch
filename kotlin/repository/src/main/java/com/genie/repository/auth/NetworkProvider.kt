package com.genie.repository.auth

import com.genie.domain.interfaces.AuthInterface
import com.genie.firebasenetwork.AuthFirebase
import com.genie.network.ApiService
import com.genie.network.model.AuthNetwork

/**
 * Created by viet.tr90@gmail.com on 7/10/20.
 */
object NetworkProvider {
    enum class AvailableNetwork {
        FIREBASE,
        REST_API
    }
    fun getAuthMethod(network: AvailableNetwork): AuthInterface {
        return if (network == AvailableNetwork.FIREBASE) {
            AuthFirebase()
        } else {
            AuthNetwork(ApiService.create("https://google.com"))
        }
    }
}