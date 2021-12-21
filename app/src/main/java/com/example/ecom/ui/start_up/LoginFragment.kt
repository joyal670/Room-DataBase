package com.example.ecom.ui.start_up

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ecom.base.BaseFragment
import com.example.ecom.databinding.FragmentLoginBinding
import com.example.ecom.ui.room.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {

    }

    override fun setupUI() {

    }

    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {

        binding.materialButton.setOnClickListener {
            val email = binding.email.text!!.trim().toString()
            val password = binding.password.text!!.trim().toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT)
                    .show()
            } else {
                GlobalScope.launch {
                    if (AppDatabase.getDatabaseClient(requireContext()).userDao()
                            .isRecordExistsUserEmail(email)
                    ) {
                        if (AppDatabase.getDatabaseClient(requireContext()).userDao()
                                .isRecordExistsUserPassword(password)
                        ) {
                            Handler(Looper.getMainLooper()).post {
                                Toast.makeText(
                                    requireContext(),
                                    "Successfully Login",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Handler(Looper.getMainLooper()).post {
                                Toast.makeText(
                                    requireContext(),
                                    "Password not Matched",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            Toast.makeText(
                                requireContext(),
                                "No such user",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

}