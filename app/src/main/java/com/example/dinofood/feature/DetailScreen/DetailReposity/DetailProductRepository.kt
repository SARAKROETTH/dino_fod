package com.example.dinofood.feature.DetailScreen.DetailReposity

import com.example.dinofood.R
import com.example.dinofood.feature.DetailScreen.model.Ingredient
import com.example.dinofood.feature.DetailScreen.model.NutritionItem

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

    fun getNutrition(): List<NutritionItem> {

        val nutrition =
            listOf<NutritionItem>(
                NutritionItem(
                    nutritionName = "Protein",
                    nutritionImage = R.drawable.ic_egg_protein,
                    nutritionValue = "0.9",
                    nutritionUnit = "g/",
                    nutritionColor = R.color.my_light_primary
                ),
                NutritionItem(
                    nutritionName = "Protein",
                    nutritionImage = R.drawable.ic_egg_protein,
                    nutritionValue = "0.9",
                    nutritionUnit = "g/g",
                    nutritionColor = R.color.my_light_primary
                )
            );

//
        return nutrition;
    };

}