package com.example.ecom.ui.start_up

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ecom.base.BaseFragment
import com.example.ecom.databinding.FragmentSignUpBinding
import com.example.ecom.ui.room.AppDatabase
import com.example.ecom.ui.room.RoomViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SignUpFragment : BaseFragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var roomViewModel: RoomViewModel

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {


    }

    override fun setupUI() {

    }

    override fun setupViewModel() {
        roomViewModel = RoomViewModel()
    }

    override fun setupObserver() {

    }

    override fun onClicks() {
        binding.materialButton.setOnClickListener {
            val email = binding.email.text!!.trim().toString()
            val name = binding.name.text!!.trim().toString()
            val password = binding.password.text!!.trim().toString()

            if (email.isBlank() || name.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT)
                    .show()
            } else {
                GlobalScope.launch {

                    Log.e(
                        "TAG",
                        "onClicks: " + AppDatabase.getDatabaseClient(requireContext()).userDao()
                            .isRecordExistsUserEmail(email)
                    )
                    if (AppDatabase.getDatabaseClient(requireContext()).userDao()
                            .isRecordExistsUserEmail(email)
                    ) {
                        Log.e("TAG", "Already Exists")
                        Handler(Looper.getMainLooper()).post {
                            Toast.makeText(
                                requireContext(),
                                "Email Already taken",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        roomViewModel.insertData(requireContext(), email, name, password)
                        Handler(Looper.getMainLooper()).post {
                            Toast.makeText(
                                requireContext(),
                                "Successfully Signed Up",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }
        }

    }

}