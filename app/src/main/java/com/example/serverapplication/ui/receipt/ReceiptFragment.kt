package com.example.serverapplication.ui.receipt

import android.os.Bundle
import android.view.View
import com.example.serverapplication.R
import com.example.serverapplication.common.SALE_ITEM
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.databinding.FragmentReceiptBinding
import com.example.serverapplication.ext.toTableTextListItems
import com.example.serverapplication.ext.toTableTextListPayed
import com.example.serverapplication.ui.base.BaseFragment
import com.example.serverapplication.ui.receipt.adapter.ReceiptItemsAdapter


class ReceiptFragment : BaseFragment<FragmentReceiptBinding>() {

    override fun getViewBinding() = FragmentReceiptBinding.inflate(layoutInflater)

    private val itemsAdapter: ReceiptItemsAdapter by lazy {
        ReceiptItemsAdapter()
    }

    private val payedItemsAdapter: ReceiptItemsAdapter by lazy {
        ReceiptItemsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createContentOfView()
    }

    private fun getTotalPrice(item: SaleItem) = item.items.sumOf { it.amount }

    private fun createContentOfView() {
        binding.apply {
            itemsList.adapter = itemsAdapter
            payedList.adapter = payedItemsAdapter

            arguments?.getParcelable<SaleItem>(SALE_ITEM)?.let {
                docNumber.text = getString(R.string.label_doc_number, it.docNumber)
                total.setThirdTitleText(getTotalPrice(it).toString())
                cashier.setThirdTitleText(it.cashier)

                itemsAdapter.submitList(it.toTableTextListItems(R.style.ReceiptText_H4))
                payedItemsAdapter.submitList(
                    it.toTableTextListPayed(R.style.ReceiptText_H3).first()
                )
            }
        }
    }
}