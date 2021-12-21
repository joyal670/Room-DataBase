package com.example.ecom.ui.start_up

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecom.base.BaseFragment
import com.example.ecom.databinding.FragmentListUsersBinding
import com.example.ecom.ui.room.AppDatabase
import com.example.ecom.ui.room.RoomViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ListUsersFragment : BaseFragment() {

    private lateinit var binding: FragmentListUsersBinding
    private lateinit var roomViewModel: RoomViewModel
    private var userList = ArrayList<UserModel>()

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListUsersBinding.inflate(inflater!!, container, false)
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

        roomViewModel.getDetails(requireContext())!!.observe(this, {
            if (it != null) {
                userList.clear()
                for (i in it.indices) {
                    userList.add(UserModel(it[i].userEmail, it[i].userName, it[i].userPassword))
                }
                setupRecyclerViewList()
            }
        })

    }

    private fun setupRecyclerViewList() {
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = MainAdapter(userList, { deleteUser(it) }, { updateUser(it) })
    }

    private fun updateUser(userEmail: String) {
        GlobalScope.launch {
            roomViewModel.updateData(requireContext(), userEmail, "joyal", "123")
        }
    }

    private fun deleteUser(userEmail: String) {
        GlobalScope.launch {
            if (AppDatabase.getDatabaseClient(requireContext()).userDao()
                    .isRecordExistsUserEmail(userEmail)
            ) {
                roomViewModel.deleteData(requireContext(), userEmail)
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(
                        requireContext(),
                        "Deleted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(
                        requireContext(),
                        "Email not exists",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onClicks() {

    }

}