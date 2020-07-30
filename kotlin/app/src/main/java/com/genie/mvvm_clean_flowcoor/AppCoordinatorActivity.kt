package com.genie.mvvm_clean_flowcoor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genie.mvvm_clean_flowcoor.auth.AuthCoordinatorActivity

class AppCoordinatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_coordinator)
        launchApp()
    }

    private fun launchApp() {
        var login = false
        if (login) {
            // Show something else
        } else {
            showAuthFlow()
        }
    }

    private fun showAuthFlow() {
        startActivity(Intent(this, AuthCoordinatorActivity::class.java))
    }

}
