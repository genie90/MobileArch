package com.genie.mvvm_clean_flowcoor.auth.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.genie.mvvm_clean_flowcoor.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.login_fragment, container, false)
        setupViewBehavior(v)
        setupViewAction(v)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setupObservableObject(viewModel)
    }


    private fun setupViewBehavior(v: View) {
        v.findViewById<AppCompatEditText>(R.id.loginPhone)
            .setOnFocusChangeListener { vv, hasFocus ->
                run {
                    if (!hasFocus && (viewModel.phoneValid.value == null || !viewModel.phoneValid.value!!))
                        (vv as AppCompatEditText).error = "Enter correct phone number"
                }
            }
    }

    private fun setupViewAction(v: View) {
        v.findViewById<AppCompatButton>(R.id.registerButton)
            .setOnClickListener {
                NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_registerPhoneFragment)
            }
        v.findViewById<AppCompatButton>(R.id.loginButton).setOnClickListener {
            viewModel.doLogin()
                .observe(this.viewLifecycleOwner, Observer { s ->
                    run {
//                        if (s)
//                            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_dashboardNavGraph)
                    }
                })
        }

        v.findViewById<AppCompatEditText>(R.id.loginPhone)
            .addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    viewModel.phone.value = s.toString()
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

        v.findViewById<AppCompatEditText>(R.id.loginPassword)
            .addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    viewModel.password.value = s.toString()
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
    }

    private fun setupObservableObject(viewModel: LoginViewModel) {
        viewModel.loginEnable.observe(this.viewLifecycleOwner,
            Observer { e -> view?.findViewById<AppCompatButton>(R.id.loginButton)?.isEnabled = e })

        viewModel.phoneValid.observe(this.viewLifecycleOwner,
            Observer { e -> view?.findViewById<AppCompatButton>(R.id.loginButton)?.isEnabled = e })

    }

}
