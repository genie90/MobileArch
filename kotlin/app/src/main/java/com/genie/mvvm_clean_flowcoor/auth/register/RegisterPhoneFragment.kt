package com.genie.mvvm_clean_flowcoor.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.genie.mvvm_clean_flowcoor.R

class RegisterPhoneFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterPhoneFragment()
    }

    private lateinit var viewModel: RegisterPhoneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_phone_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPhoneViewModel::class.java)
    }

}
