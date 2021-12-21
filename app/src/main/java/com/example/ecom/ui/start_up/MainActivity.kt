package com.example.ecom.ui.start_up

import com.example.ecom.R
import com.example.ecom.base.BaseActivity
import com.example.ecom.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main
    override val hideStatusBar: Boolean
        get() = false

    override fun getViewBinging(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initData() {

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