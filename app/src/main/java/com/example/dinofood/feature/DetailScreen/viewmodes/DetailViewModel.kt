package com.example.dinofood.feature.DetailScreen.viewmodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dinofood.feature.DetailScreen.DetailReposity.DetailProductRepository
import com.example.dinofood.feature.DetailScreen.model.Ingredient

class DetailViewModel(
    private val repository: DetailProductRepository
) : ViewModel() {

    private val _ingredients = MutableLiveData<List<Ingredient>>()
    val ingredients: LiveData<List<Ingredient>> = _ingredients



    fun loadIngredient(){
        _ingredients.value = repository.getIngredients()
    }


//   adapter



}