package com.genie.mvvm_clean_flowcoor.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.genie.mvvm_clean_flowcoor.AppCoordinatorActivity
import com.genie.mvvm_clean_flowcoor.R
import com.genie.mvvm_clean_flowcoor.main.DashboardCallback

class HomeFragment : Fragment() {

    lateinit var callback: DashboardCallback

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.home_fragment, container, false)
        setupViewBehavior(v)
        setupViewAction(v)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setupObservableObject(viewModel)
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppCoordinatorActivity) {
            callback = context
        }
    }

    private fun setupViewBehavior(v: View) {

    }

    private fun setupViewAction(v: View) {
        v.findViewById<Button>(R.id.homeLogin).setOnClickListener {
            callback.requestAuth()
        }
    }

    private fun setupObservableObject(viewModel: HomeViewModel) {


    }

}
