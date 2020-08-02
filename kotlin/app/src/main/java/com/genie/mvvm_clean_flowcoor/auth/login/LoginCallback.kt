package com.genie.mvvm_clean_flowcoor.auth.login

/**
 * Created by viet.tr90@gmail.com on 30/7/20.
 */
interface LoginCallback {
    fun loginSuccess()
    fun openRegister()
    fun openResetPass()
}