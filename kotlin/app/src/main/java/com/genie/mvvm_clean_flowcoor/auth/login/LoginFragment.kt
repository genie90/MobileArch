package com.genie.mvvm_clean_flowcoor.auth.login

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton

import com.genie.mvvm_clean_flowcoor.R

class LoginFragment : Fragment() {

    private lateinit var callback: LoginCallback
    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.login_fragment, container, false)
        v.findViewById<AppCompatButton>(R.id.registerButton).setOnClickListener { callback.openRegister() }
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is LoginCallback) {
            callback = parentFragment as LoginCallback
        }
    }

}
