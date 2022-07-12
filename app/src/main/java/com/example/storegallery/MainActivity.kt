package com.example.storegallery

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.storegallery.adapters.StoreAdapter
import com.example.storegallery.data.Category
import com.example.storegallery.data.listOfItems
import com.example.storegallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: StoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapters()
        filter()

    }

    private fun initAdapters() {
        adapter = StoreAdapter()
        binding.rvItems.layoutManager = GridLayoutManager(this, 2)
        binding.rvItems.adapter = adapter

    }

    @SuppressLint("ResourceAsColor")
    private fun filter() {

        val btnAll = binding.btnCategoryType1
        val btnParty = binding.btnCategoryType2
        val btnCamping = binding.btnCategoryType3
        val btnRain = binding.btnCategoryType4
        val btnSummer = binding.btnCategoryType5
        val btnWinter = binding.btnCategoryType6
        val btnAutumn = binding.btnCategoryType7


        btnAll.setOnClickListener {
            adapter.showListByCategory(btnAll.text.toString(), listOfItems)
        }
        btnParty.setOnClickListener {
            adapter.showListByCategory(btnParty.text.toString(), listOfItems)
        }
        btnCamping.setOnClickListener {
            adapter.showListByCategory(btnCamping.text.toString(), listOfItems)
        }
        btnRain.setOnClickListener {
            adapter.showListByCategory(btnRain.text.toString(), listOfItems)
        }
        btnSummer.setOnClickListener {
            adapter.showListByCategory(btnSummer.text.toString(), listOfItems)
        }
        btnWinter.setOnClickListener {
            adapter.showListByCategory(btnWinter.text.toString(), listOfItems)
        }
        btnAutumn.setOnClickListener {
            adapter.showListByCategory(btnAutumn.text.toString(), listOfItems)
        }
    }
}