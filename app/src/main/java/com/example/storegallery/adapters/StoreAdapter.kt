package com.example.storegallery.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storegallery.data.Category
import com.example.storegallery.data.Clothes
import com.example.storegallery.data.filteredListOfItems
import com.example.storegallery.databinding.ItemStoreBinding

class StoreAdapter : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

    inner class StoreViewHolder(private var binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var item: Clothes
        fun bindFunction() {
            item = filteredListOfItems[adapterPosition]
            binding.apply {
                ivItem.setImageResource(item.image)
                tvTitle.text = item.title
                tvPrice.text = item.price
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            ItemStoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bindFunction()
    }

    override fun getItemCount() = filteredListOfItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun showListByCategory(category: String, allDataList: List<Clothes>) {

        when (category) {
            Category.ALL.name -> {
                filteredListOfItems = allDataList as MutableList<Clothes>
            }
            Category.PARTY.name -> {
                filteredListOfItems =
                    allDataList.filter { it.categoryType == Category.PARTY.name } as MutableList<Clothes>
            }
            Category.CAMPING.name -> {
                filteredListOfItems =
                    allDataList.filter { it.categoryType == Category.CAMPING.name } as MutableList<Clothes>
            }
            Category.RAIN.name -> {
                filteredListOfItems =
                    allDataList.filter { it.categoryType == Category.RAIN.name } as MutableList<Clothes>
            }
            Category.SUMMER.name-> {
                filteredListOfItems =
                    allDataList.filter { it.categoryType == Category.SUMMER.name } as MutableList<Clothes>
            }
            Category.WINTER.name -> {
                filteredListOfItems =
                    allDataList.filter { it.categoryType == Category.WINTER.name } as MutableList<Clothes>
            }
            Category.AUTUMN.name -> {
                filteredListOfItems =
                    allDataList.filter { it.categoryType == Category.AUTUMN.name } as MutableList<Clothes>
            }
            else -> {
                filteredListOfItems = allDataList as MutableList<Clothes>
            }
        }
        notifyDataSetChanged()
    }
}