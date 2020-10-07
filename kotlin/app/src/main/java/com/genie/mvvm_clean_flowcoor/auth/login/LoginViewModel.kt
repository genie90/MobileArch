package com.genie.mvvm_clean_flowcoor.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.genie.domain.entity.UserEntity
import com.genie.mvvm_clean_flowcoor.utils.Utils.combineLatest
import com.genie.repository.auth.AuthRepository

class LoginViewModel : ViewModel() {

    var phone: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var phoneValid: LiveData<Boolean> = Transformations.map(phone) { p -> p.length > 9 }
    var passwordValid: LiveData<Boolean> = Transformations.map(password) { p -> p.length > 6 }
    var loginEnable: LiveData<Boolean> =
        Transformations.map(phoneValid.combineLatest(passwordValid)) { (a, b) -> a && b }

    fun doLogin(): LiveData<UserEntity> {
        return AuthRepository.login(phone.value, password.value)
    }


}
