package com.genie.mvvm_clean_flowcoor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment

class OnBoardingFragment : Fragment() {

    companion object {
        fun newInstance() = OnBoardingFragment()
    }

    private lateinit var viewModel: OnBoardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.on_boarding_fragment, container, false)
        setupViewBehavior(v)
        setupViewAction(v)
        viewModel = ViewModelProvider(this).get(OnBoardingViewModel::class.java)
        setupObservableObject(viewModel)
        return v
    }

    private fun setupViewBehavior(v: View) {

    }

    private fun setupViewAction(v: View) {
        v.findViewById<Button>(R.id.homeLogin).setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_onBoardingFragment_to_dashboard_nav_graph)
        }
    }

    private fun setupObservableObject(viewModel: OnBoardingViewModel) {


    }

}
