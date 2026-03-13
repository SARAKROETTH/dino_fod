package com.example.dinofood.feature.DetailScreen.DetailReposity

import com.example.dinofood.R
import com.example.dinofood.feature.DetailScreen.model.Ingredient
import com.example.dinofood.feature.DetailScreen.model.ProductDetail
import kotlin.random.Random

class DetailProductRepository {


    fun getIngredients(): List<Ingredient>{

        val ingredients = listOf<Ingredient>(
            Ingredient( ingredientName = "Carrot", ingredientImage = R.drawable.carrot),
            Ingredient( ingredientName = "Carrot", ingredientImage = R.drawable.carrot),
            Ingredient( ingredientName = "Carrot", ingredientImage = R.drawable.carrot),
            Ingredient( ingredientName = "Carrot", ingredientImage = R.drawable.carrot),
        )
        return ingredients
    };


}