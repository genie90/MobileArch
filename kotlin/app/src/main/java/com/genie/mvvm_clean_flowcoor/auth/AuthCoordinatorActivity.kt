package com.genie.mvvm_clean_flowcoor.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.genie.mvvm_clean_flowcoor.R
import com.genie.mvvm_clean_flowcoor.auth.login.LoginFragment

class AuthCoordinatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_coordinator)
        showLoginScreen()
    }

    private fun showLoginScreen() {
        showAnAuthScreen(LoginFragment.newInstance())
    }

    private fun showAnAuthScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.authContainer, fragment)
            .commit()
    }

    interface 
}
