package com.genie.mvvm_clean_flowcoor.auth.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.genie.mvvm_clean_flowcoor.R

class RegisterPhoneOtpFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterPhoneOtpFragment()
    }

    private lateinit var viewModel: RegisterPhoneOtpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_phone_otp_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPhoneOtpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
