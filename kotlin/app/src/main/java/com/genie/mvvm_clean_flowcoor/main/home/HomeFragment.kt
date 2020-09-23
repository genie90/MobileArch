package com.genie.mvvm_clean_flowcoor.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.genie.mvvm_clean_flowcoor.R

class HomeFragment : Fragment() {

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

    private fun setupViewBehavior(v: View) {

    }

    private fun setupViewAction(v: View) {
        v.findViewById<Button>(R.id.homeLogin).setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_authNavGraph)
        }
    }

    private fun setupObservableObject(viewModel: HomeViewModel) {


    }

}
