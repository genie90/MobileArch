package com.genie.mvvm_clean_flowcoor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.genie.mvvm_clean_flowcoor.auth.AuthCoordinator


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
        supportFragmentManager.beginTransaction()
            .add(R.id.appContainer, AuthCoordinator.newInstance())
            .commit()
    }

    override fun onBackPressed() {
        for (frag in supportFragmentManager.fragments) {
            if (frag.isVisible) {
                val childFm: FragmentManager = frag.childFragmentManager
                if (childFm.backStackEntryCount > 0) {
                    childFm.popBackStack()
                    return
                }
            }
        }
        super.onBackPressed()
    }
}
