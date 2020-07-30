package com.genie.mvvm_clean_flowcoor.auth.login

import androidx.lifecycle.*

class LoginViewModel : ViewModel() {

    var phone: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var phoneValid: LiveData<Boolean> = Transformations.map(phone) { p -> p.length > 9 }
    var passwordValid: LiveData<Boolean> = Transformations.map(password) { p -> p.length > 6 }
    var loginEnable: LiveData<Boolean> = Transformations.map(phoneValid.combineLatest(passwordValid)) {(a,b) -> a && b}

    fun doLogin(): LiveData<Boolean>{
        return MutableLiveData<Boolean>().apply { value = true }
    }

    fun <A, B> LiveData<A>.combineLatest(b: LiveData<B>): LiveData<Pair<A, B>> {
        return MediatorLiveData<Pair<A, B>>().apply {
            var lastA: A? = null
            var lastB: B? = null

            addSource(this@combineLatest) {
                if (it == null && value != null) value = null
                lastA = it
                if (lastA != null && lastB != null) value = lastA!! to lastB!!
            }

            addSource(b) {
                if (it == null && value != null) value = null
                lastB = it
                if (lastA != null && lastB != null) value = lastA!! to lastB!!
            }
        }
    }

}
