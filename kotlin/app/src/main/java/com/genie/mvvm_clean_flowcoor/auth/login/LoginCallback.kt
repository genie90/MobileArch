package com.genie.mvvm_clean_flowcoor.auth.login

/**
 * Created by genie@gobear.com on 30/7/20.
 */
interface LoginCallback {
    fun loginSuccess()
    fun openRegister()
    fun openResetPass()
}