# Daily Vitality - Grocery Shopping App

A modern Android grocery shopping application built with Kotlin and XML, featuring a complete inventory of fresh ingredients and pre-made dishes.

## 📱 Features

### Screens
- **Home Screen** - Main interface with featured ingredients and best-selling dishes
- **Menu Screen** - Complete catalog of all 25 available dishes
- **Ingredient Screens** - 14 detailed ingredient pages with information and ordering
- **Cart Screen** - Shopping cart management
- **Favorites Screen** - Save and manage favorite items
- **Profile Screen** - User profile information
- **Profile Edit Screen** - Edit user details

### Architecture
- **Modular Layout Components** - Reusable XML components for cleanest code
  - `home_header.xml` - User greeting and location
  - `home_search_bar.xml` - Search functionality
  - `home_promotional_banner.xml` - Promotional offers
  - `home_ingredients_section.xml` - All 14 ingredients
  - `home_best_selling_section.xml` - Featured 25 dishes
  - `home_bottom_navigation.xml` - Navigation bar

### Navigation
- Dynamic ingredient listeners using resource ID lookup
- Bottom navigation for Cart, Menu, Favorites, Profile
- Generic screen loader for ingredients
- Clean lambda-based navigation pattern

## 🥗 Ingredients (14 Total)

1. **Carrot** - Root vegetable, rich in beta-carotene
2. **Corn** - Fresh sweet corn
3. **Avocado** - Creamy, nutrient-dense fruit
4. **Tomato** - Fresh tomatoes
5. **Potato** - Versatile starch
6. **Broccoli** - Cruciferous vegetable
7. **Tuna** - Fresh seafood
8. **Banana** - Tropical fruit
9. **Spinach** - Leafy green
10. **Chicken** - Lean protein
11. **Fish** - White fish fillet
12. **Beef** - Premium cut
13. **Cheese** - Dairy product
14. **Pepper** - Spice

## 🍽️ Menu - 25 Dishes

### Best Sellers
1. Tuna Salad - $8.99
2. Veggie Stir-Fry - $6.49
3. Avocado Toast - $5.99
4. Baked Potato - $4.99
5. Tomato Soup - $7.49
6. Broccoli Curry - $6.99
7. Tuna Pasta - $9.49
8. Corn Salad - $5.49
9. Spinach Salad with Chicken - $7.99
10. Grilled Fish - $12.99
11. Beef Stew - $11.99
12. Cheese Pasta - $8.49

### New Additions
13. Banana Smoothie - $6.99
14. Pepper Chicken - $9.49
15. Carrot Bisque - $5.49
16. Chicken & Broccoli - $8.99
17. Fish Tacos - $10.99
18. Beef Tomato Stew - $9.99
19. Peppered Fish Fillet - $11.99
20. Broccoli Cheese Bake - $7.99
21. Spinach Cheese Quiche - $6.49
22. Tuna Tomato Pasta - $8.49
23. Corn Chicken Bowl - $7.49
24. Spicy Beef & Pepper - $10.99
25. Carrot Chicken Mix - $8.49

## 🏗️ Project Structure

```
app/
├── src/main/
│   ├── java/com/example/dinofood/
│   │   └── MainActivity.kt (99 lines, optimized)
│   └── res/layout/
│       ├── home_screen.xml
│       ├── menu_screen.xml
│       ├── cart_screen.xml
│       ├── favorite_screen.xml
│       ├── profile_screen.xml
│       ├── profile_edit_screen.xml
│       ├── home_*.xml (6 modular components)
│       └── ingredient_*_screen.xml (14 ingredient screens)
```

## 🔧 Technical Stack

- **Language:** Kotlin
- **UI Framework:** Android XML Layouts with AndroidX
- **Navigation:** Manual `setContentView()` with click listeners
- **Build System:** Gradle
- **Target Device:** Android API 21+
- **Dependencies:** AndroidX AppCompat

## 📲 Installation

### Requirements
- Android Studio
- Android SDK 21+
- ADB (for device deployment)

### Build & Run
```bash
# Build APK
./gradlew clean assembleDebug

# Install on device
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch app
adb shell am start -n com.example.dinofood/.MainActivity
```

## 📋 Recent Updates

### Version 2.0 (March 2, 2026)
- ✅ Expanded menu from 14 to 25 dishes
- ✅ Created modular home screen components
- ✅ Added dedicated Menu screen for full catalog
- ✅ Refactored MainActivity from 327 to 99 lines (70% code reduction)
- ✅ Implemented dynamic ingredient listeners
- ✅ Added 6 ingredient screens (Spinach, Chicken, Fish, Beef, Cheese, Pepper)

### Version 1.0
- 5 main screens (Home, Cart, Favorites, Profile, Profile Edit)
- 14 ingredient detail screens
- 14 ingredients with dedicated pages
- 12 initial dishes
- Bottom navigation system

## 🎨 Design Features

- **Color-Coded UI** - Each ingredient has unique accent color
- **Responsive Layout** - Scrollable content areas
- **Clean Components** - Modular XML structure
- **Consistent Styling** - Unified design system

## 📝 Code Highlights

### Dynamic Ingredient Setup (No Hardcoding)
```kotlin
private fun setupIngredientListeners() {
    for (ingredient in ingredients) {
        val ingredientId = resources.getIdentifier(
            "ingredient_${ingredient}_home", "id", packageName
        )
        val ingredientView = findViewById<LinearLayout>(ingredientId)
        ingredientView?.setOnClickListener {
            showIngredientScreen(ingredient)
        }
    }
}
```

### Generic Navigation Helper
```kotlin
private fun navigateTo(layoutId: Int, setupFunction: () -> Unit) {
    setContentView(layoutId)
    setupFunction()
}
```

## 🚀 Future Enhancements

- Database integration for persistence
- User authentication
- Shopping cart functionality
- Payment processing
- Order tracking
- Real-time inventory
- Recipe suggestions
- Nutritional information

## 📱 Device Status

- **Target Device:** Google Pixel 7 Pro (Cheetah)
- **APK Size:** 13.04 MB
- **Installation:** Successful via USB/ADB
- **Status:** Running without errors

## 👤 Author

Daily Vitality Development Team

## 📄 License

MIT License - Feel free to use and modify
