package com.example.dinofood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    
    // Ingredient list for cleaner iteration
    private val ingredients = listOf(
        "carrot", "corn", "avocado", "tomato", "potato", "broccoli", "tuna", "banana",
        "spinach", "chicken", "fish", "beef", "cheese", "pepper"
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        setupHomeScreen()
    }
    
    private fun setupHomeScreen() {
        // Set up all ingredient click listeners
        setupIngredientListeners()
        
        // Set up navigation buttons
        setupNavigationButtons()
    }
    
    private fun setupIngredientListeners() {
        for (ingredient in ingredients) {
            val ingredientId = resources.getIdentifier("ingredient_${ingredient}_home", "id", packageName)
            val ingredientView = findViewById<LinearLayout>(ingredientId)
            ingredientView?.setOnClickListener {
                showIngredientScreen(ingredient)
            }
        }
    }
    
    private fun showIngredientScreen(ingredient: String) {
        val layoutId = resources.getIdentifier("ingredient_${ingredient}_screen", "layout", packageName)
        if (layoutId != 0) {
            setContentView(layoutId)
            setupIngredientScreen()
        }
    }
    
    private fun setupIngredientScreen() {
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
    }
    
    private fun setupNavigationButtons() {
        // Menu button
        val menuButton = findViewById<LinearLayout>(R.id.menu_button_home)
        menuButton?.setOnClickListener {
            navigateTo(R.layout.menu_screen, ::setupMenuScreen)
        }
        
        // Cart button
        val cartButton = findViewById<LinearLayout>(R.id.cart_button)
        cartButton?.setOnClickListener {
            navigateTo(R.layout.cart_screen, ::setupCartScreen)
        }
        
        // Favorites button
        val favoritesButton = findViewById<LinearLayout>(R.id.favorites_button)
        favoritesButton?.setOnClickListener {
            navigateTo(R.layout.favorite_screen, ::setupFavoriteScreen)
        }
        
        // Profile button
        val profileButton = findViewById<LinearLayout>(R.id.profile_button)
        profileButton?.setOnClickListener {
            navigateTo(R.layout.profile_screen, ::setupProfileScreen)
        }
    }
    
    private fun navigateTo(layoutId: Int, setupFunction: () -> Unit) {
        setContentView(layoutId)
        setupFunction()
    }
    
    private fun setupCartScreen() {
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
    }
    
    private fun setupFavoriteScreen() {
        // Back button
        val backButton = findViewById<ImageView>(R.id.back_button_favorite)
        backButton?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
        
        // Bottom navigation - Home
        val navHome = findViewById<LinearLayout>(R.id.nav_home_from_favorite)
        navHome?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
        
        // Bottom navigation - Profile
        val navProfile = findViewById<LinearLayout>(R.id.nav_profile_from_favorite)
        navProfile?.setOnClickListener {
            setContentView(R.layout.profile_screen)
            setupProfileScreen()
        }
    }
    
    private fun setupMenuScreen() {
        // Back button
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
    }
    
    private fun setupProfileScreen() {
        // Back button
        val backButton = findViewById<ImageView>(R.id.back_button_profile)
        backButton?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
        
        // Bottom navigation - Home
        val navHome = findViewById<LinearLayout>(R.id.nav_home_from_profile)
        navHome?.setOnClickListener {
            setContentView(R.layout.home_screen)
            setupHomeScreen()
        }
        
        // Bottom navigation - Favorite
        val navFavorite = findViewById<LinearLayout>(R.id.nav_favorite_from_profile)
        navFavorite?.setOnClickListener {
            setContentView(R.layout.favorite_screen)
            setupFavoriteScreen()
        }
        
        // Edit profile button
        val editButton = findViewById<LinearLayout>(R.id.settings_button_profile)
        editButton?.setOnClickListener {
            setContentView(R.layout.profile_edit_screen)
            setupProfileEditScreen()
        }
    }
    
    private fun setupProfileEditScreen() {
        // Back button
        val backButton = findViewById<ImageView>(R.id.back_button_profile_edit)
        backButton?.setOnClickListener {
            setContentView(R.layout.profile_screen)
            setupProfileScreen()
        }
        
        // Save button
        val saveButton = findViewById<LinearLayout>(R.id.save_profile_button)
        saveButton?.setOnClickListener {
            setContentView(R.layout.profile_screen)
            setupProfileScreen()
        }
        
        // Cancel button
        val cancelButton = findViewById<LinearLayout>(R.id.cancel_profile_button)
        cancelButton?.setOnClickListener {
            setContentView(R.layout.profile_screen)
            setupProfileScreen()
        }
    }
}