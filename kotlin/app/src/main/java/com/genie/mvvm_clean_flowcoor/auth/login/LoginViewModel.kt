package com.genie.mvvm_clean_flowcoor.auth.login

import androidx.lifecycle.*
import com.genie.mvvm_clean_flowcoor.utils.Utils.combineLatest

class LoginViewModel : ViewModel() {

    var phone: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var phoneValid: LiveData<Boolean> = Transformations.map(phone) { p -> p.length > 9 }
    var passwordValid: LiveData<Boolean> = Transformations.map(password) { p -> p.length > 6 }
    var loginEnable: LiveData<Boolean> = Transformations.map(phoneValid.combineLatest(passwordValid)) { (a,b) -> a && b}

    fun doLogin(): LiveData<Boolean>{
        return MutableLiveData<Boolean>().apply { value = true }
    }


}
