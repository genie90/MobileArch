package com.genie.network.model.respond

import com.google.gson.annotations.SerializedName

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
class LoginResult {

    @SerializedName("token")
    var token: String = ""
    @SerializedName("userId")
    var userId: String = ""
    @SerializedName("phone")
    var phone: String = ""
    @SerializedName("email")
    var email: String = ""
}