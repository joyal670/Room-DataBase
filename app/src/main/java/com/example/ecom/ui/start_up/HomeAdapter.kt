package com.example.ecom.ui.start_up

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(fm: FragmentManager?, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm!!, lifecycle) {

    private val items: Int = 4

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = SignUpFragment()
            1 -> fragment = LoginFragment()
            2 -> fragment = ForgotPasswordFragment()
            3 -> fragment = ListUsersFragment()
        }
        return fragment!!
    }

    override fun getItemCount(): Int {
        return items
    }
}