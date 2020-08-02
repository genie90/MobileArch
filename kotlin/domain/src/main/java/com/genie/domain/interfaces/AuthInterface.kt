package com.genie.domain.interfaces

import com.genie.domain.entity.UserEntity

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
interface AuthInterface {
    fun signUpWithPhone(phone: String): Any
    fun signInWithPhoneAndPassword(phone: String, password: String): UserEntity
}