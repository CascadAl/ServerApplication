package com.example.serverapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.serverapplication.R
import com.example.serverapplication.common.SALE_ITEM
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.databinding.FragmentMainBinding
import com.example.serverapplication.ext.toGone
import com.example.serverapplication.ext.toVisible
import com.example.serverapplication.ui.base.BaseFragment
import com.example.serverapplication.ui.main.adapter.SalesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainFragmentViewModel by viewModels()
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    private val adapter: SalesAdapter by lazy {
        SalesAdapter(
            onClick = ::navigateToReceiptScreen
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createContentOfView()
    }

    private fun createContentOfView() {
        binding.salesList.adapter = adapter

        lifecycleScope.launch {
            viewModel.getAllReceipts()?.observe(viewLifecycleOwner) {
                binding.apply {
                    errorText.toGone()

                    adapter.submitList(it)
                    salesList.toVisible()
                }
            }
        }
    }

    private fun navigateToReceiptScreen(item: SaleItem) {
        navigateTo(R.id.toReceiptFragment, bundleOf(SALE_ITEM to item))
    }
}