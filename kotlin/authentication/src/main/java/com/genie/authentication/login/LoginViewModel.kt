package com.genie.authentication.login

import androidx.lifecycle.*
import com.genie.domain.entity.UserEntity
import com.genie.authentication.utils.Utils.combineLatest
import com.genie.repository.auth.AuthRepository

class LoginViewModel : ViewModel() {

    var phone: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var phoneValid: LiveData<Boolean> = Transformations.map(phone) { p -> p.length > 9 }
    var passwordValid: LiveData<Boolean> = Transformations.map(password) { p -> p.length > 6 }
    var loginEnable: LiveData<Boolean> =
        Transformations.map(phoneValid.combineLatest(passwordValid)) { (a, b) -> a && b }

    fun doLogin(): LiveData<UserEntity> {
       return LiveDataReactiveStreams.fromPublisher<UserEntity> { AuthRepository.login(phone.value, password.value) }
    }
}
