package com.genie.mvvm_clean_flowcoor.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.genie.mvvm_clean_flowcoor.R

class DashboardCoordinator : Fragment() {

    companion object {
        fun newInstance() = DashboardCoordinator()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dashboard_coordinator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.dashboard_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

}
