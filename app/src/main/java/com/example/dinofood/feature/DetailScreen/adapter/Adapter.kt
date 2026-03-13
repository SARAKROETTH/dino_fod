package com.example.dinofood.feature.DetailScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinofood.databinding.IngredientItemCardBinding
import com.example.dinofood.feature.DetailScreen.model.Ingredient

class Adapter(private val list: List<Ingredient>): RecyclerView.Adapter<Adapter.ViewHolder>() {

//    Box to import the RecycleView
    inner class ViewHolder(val binding: IngredientItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)

//    Call binding to use
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val binding = IngredientItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
// Box to show text ,image ,or something that i want
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.showNameIngrendient.text = list[position].ingredientName;
        holder.binding.showwImageIngredient.setImageResource(list[position].ingredientImage);
    }

    override fun getItemCount(): Int {
        return list.size
    }




}