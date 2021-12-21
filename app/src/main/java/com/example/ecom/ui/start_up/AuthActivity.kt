package com.example.ecom.ui.start_up

import android.util.Log
import com.example.ecom.R
import com.example.ecom.base.BaseActivity
import com.example.ecom.databinding.ActivityAuthBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator




class AuthActivity : BaseActivity<ActivityAuthBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_auth
    override val hideStatusBar: Boolean
        get() = false

    override fun getViewBinging(): ActivityAuthBinding = ActivityAuthBinding.inflate(layoutInflater)

    override fun initData() {

       /* setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.elevation = 0F*/

        binding.homeViewPager.adapter = HomeAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(
            binding.tabs,
            binding.homeViewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Sign Up"
                1 -> tab.text = "Login"
                2 -> tab.text = "Forgot Password"
                3 -> tab.text = "All Users"
            }
        }.attach()
    }

    override fun fragmentLaunch() {

    }

    override fun setupUI() {


    }

    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {

    }

}