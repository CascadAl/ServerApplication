package com.example.serverapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.databinding.ItemSalesBinding

class SalesAdapter(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {

    private val sales = mutableListOf<SaleItem>()

    class SalesViewHolder(
        private val binding: ItemSalesBinding,
        private val onClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SaleItem) {
            binding.apply {
                receiptNum.text = "# ${item.docNumber}"
                container.setOnClickListener {
                    onClick(item.docNumber)
                }
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClick: (String) -> Unit
            ): SalesViewHolder {
                return LayoutInflater.from(parent.context).let {
                    SalesViewHolder(ItemSalesBinding.inflate(it, parent, false), onClick)
                }
            }
        }
    }

    fun submitList(list: List<SaleItem>) {
        sales.clear()
        sales.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        return SalesViewHolder.create(parent, onClick)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.bind(sales[position])
    }

    override fun getItemCount() = sales.size

}