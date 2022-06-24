package com.example.serverapplication.ui.main.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.serverapplication.R
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.databinding.ItemSalesBinding

class SalesAdapter(
    private val onClick: (SaleItem) -> Unit
) : RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {

    private val sales = mutableListOf<SaleItem>()

    class SalesViewHolder(
        private val binding: ItemSalesBinding,
        private val onClick: (SaleItem) -> Unit,
        private val resources: Resources
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SaleItem) {
            binding.apply {
                receiptNum.text = resources.getString(R.string.label_doc_number, item.docNumber)
                container.setOnClickListener {
                    onClick(item)
                }
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClick: (SaleItem) -> Unit
            ): SalesViewHolder {
                return LayoutInflater.from(parent.context).let {
                    SalesViewHolder(
                        ItemSalesBinding.inflate(it, parent, false),
                        onClick,
                        parent.resources
                    )
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