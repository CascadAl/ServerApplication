package com.example.serverapplication.ui.receipt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.serverapplication.databinding.ItemReceiptListBinding
import com.example.serverapplication.widget.common.TableTextViewInfo

class ReceiptItemsAdapter : RecyclerView.Adapter<ReceiptItemsAdapter.ReceiptItemsViewHolder>() {

    private val receiptList = mutableListOf<TableTextViewInfo>()

    fun submitList(list: List<TableTextViewInfo>) {
        receiptList.clear()
        receiptList.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    class ReceiptItemsViewHolder(
        private val binding: ItemReceiptListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TableTextViewInfo) {
            binding.container.invalidateView(item)
        }

        companion object {
            fun create(
                parent: ViewGroup
            ): ReceiptItemsViewHolder {
                return LayoutInflater.from(parent.context).let {
                    ReceiptItemsViewHolder(
                        ItemReceiptListBinding.inflate(it, parent, false)
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptItemsViewHolder {
        return ReceiptItemsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ReceiptItemsViewHolder, position: Int) {
        holder.bind(receiptList[position])
    }

    override fun getItemCount() = receiptList.size

}