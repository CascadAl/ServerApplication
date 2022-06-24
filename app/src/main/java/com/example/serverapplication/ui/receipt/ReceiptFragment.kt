package com.example.serverapplication.ui.receipt

import android.os.Bundle
import android.view.View
import com.example.serverapplication.databinding.FragmentReceiptBinding
import com.example.serverapplication.ui.base.BaseFragment


class ReceiptFragment : BaseFragment<FragmentReceiptBinding>() {

    override fun getViewBinding() = FragmentReceiptBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}