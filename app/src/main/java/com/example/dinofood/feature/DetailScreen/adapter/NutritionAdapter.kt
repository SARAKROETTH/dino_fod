package com.example.dinofood.feature.DetailScreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinofood.databinding.NutritionItemCardBinding
import com.example.dinofood.feature.DetailScreen.model.NutritionItem
import kotlin.random.Random

class NutritionAdapter(private val nutritionList: List<NutritionItem>) : RecyclerView.Adapter<NutritionAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: NutritionItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val binding = NutritionItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {


    }

    override fun getItemCount(): Int {
        return nutritionList.size
    }



}