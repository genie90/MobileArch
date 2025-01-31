package com.genie.firebasenetwork

import com.genie.domain.entity.UserEntity
import com.genie.domain.interfaces.AuthInterface
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.reactivex.rxjava3.core.Single

/**
 * Created by viet.tr90@gmail.com on 7/10/20.
 */
class AuthFirebase : AuthInterface {
    private lateinit var auth: FirebaseAuth

    override fun signUpWithPhone(phone: String): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signInWithPhoneAndPassword(
        phone: String?,
        password: String?
    ): Single<UserEntity> {

        return Single.create { emitter ->
            auth.signInWithEmailAndPassword(phone!!, password!!).addOnCompleteListener {
                if (it.isSuccessful) {
                    emitter.apply {
                        val user: FirebaseUser = it.result!!.user!!
                        UserEntity(user.uid, user.phoneNumber!!, user.email!!)
                    }
                } else {
                    emitter!!.onError(Throwable())
                }
            }
        }
    }


}