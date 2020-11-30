package com.genie.mvvm_clean_flowcoor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.genie.authentication.AuthCallback
import com.genie.mvvm_clean_flowcoor.main.DashboardCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppCoordinatorActivity : AppCompatActivity(), AuthCallback, DashboardCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_coordinator)
        launchApp()
    }

    private fun launchApp() {
        var login = true
        if (login) {
            showHomeFlow()
        }
    }

    private fun showAuthFlow() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_dashboardCoordinator_to_authCoordinator)
    }

    private fun showHomeFlow() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_onBoardingFragment_to_dashboard_nav_graph)
    }

    override fun loginSucceed() {
        showHomeFlow()
    }

    override fun requestAuth() {
        showAuthFlow()
    }
}
