package com.genie.mvvm_clean_flowcoor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.genie.mvvm_clean_flowcoor.auth.AuthCallback
import com.genie.mvvm_clean_flowcoor.auth.AuthCoordinator


class AppCoordinatorActivity : AppCompatActivity(), AuthCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_coordinator)
        launchApp()

    }

    private fun launchApp() {
        var login = true
        if (login) {
            showHomeFlow()
        } else {
            showAuthFlow()
        }
    }

    private fun showAuthFlow() {
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        navController.navigate(R.id.action_dashboardCoordinator_to_authCoordinator)
    }

    private fun showHomeFlow() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_onBoardingFragment_to_dashboard_nav_graph)
    }


//    override fun onBackPressed() {
//        for (frag in supportFragmentManager.fragments) {
//            if (frag.isVisible) {
//                val childFm: FragmentManager = frag.childFragmentManager
//                if (childFm.backStackEntryCount > 0) {
//                    childFm.popBackStack()
//                    return
//                }
//            }
//        }
//        super.onBackPressed()
//    }

    override fun loginSucceed() {
        showHomeFlow()
    }
}
