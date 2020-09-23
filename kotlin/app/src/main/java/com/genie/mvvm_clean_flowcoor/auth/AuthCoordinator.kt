package com.genie.mvvm_clean_flowcoor.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.genie.mvvm_clean_flowcoor.R

class AuthCoordinator : Fragment() {

    companion object {
        fun newInstance() = AuthCoordinator()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.auth_coordinator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.auth_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    private fun showAnAuthScreen(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.authContainer, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}
