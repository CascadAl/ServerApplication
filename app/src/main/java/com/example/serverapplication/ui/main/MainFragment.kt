package com.example.serverapplication.ui.main

import android.os.Bundle
import android.view.View
import com.example.serverapplication.R
import com.example.serverapplication.databinding.FragmentMainBinding
import com.example.serverapplication.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            navigateTo(R.id.toReceiptFragment)
        }
    }
}