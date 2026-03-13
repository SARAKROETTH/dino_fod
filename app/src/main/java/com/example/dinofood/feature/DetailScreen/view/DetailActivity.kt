package com.example.dinofood.feature.DetailScreen.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dinofood.R
import com.example.dinofood.databinding.ActivityDetailBinding
import com.example.dinofood.feature.DetailScreen.DetailReposity.DetailProductRepository
import com.example.dinofood.feature.DetailScreen.adapter.Adapter
import com.example.dinofood.feature.DetailScreen.viewmodes.DetailViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var adapter: Adapter
    private lateinit var viewModel: DetailViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val repository : DetailProductRepository = DetailProductRepository()

        viewModel = ViewModelProvider(this, DetailViewModelFactory(repository))[DetailViewModel::class.java]


//        reading of adapter
        viewModel.loadIngredient();
        viewModel.ingredients.observe(this) { ingredients ->
            adapter = Adapter(ingredients)
            binding.itemIngrediant.layoutManager = LinearLayoutManager(this);
            binding.itemIngrediant.adapter = adapter

//            in the flutter is safeArea
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        scrollEventTriger(binding)
    }

}

    private fun loadNutruition(){

    }
//   Scroll event to show button add to card
    private fun scrollEventTriger(binding : ActivityDetailBinding ): Unit {

        binding.scrollContainer.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->

            if (scrollY > oldScrollY) {

                // scrolling down → hide
                binding.btnAddToCart.animate()
                    .translationY(binding.btnAddToCart.height.toFloat())
                    .setDuration(300)
                    .withEndAction {
                        binding.btnAddToCart.visibility = View.GONE
                    }
                    .start()

            } else if (scrollY < oldScrollY) {
                // scrolling up → show
                binding.btnAddToCart.visibility = View.VISIBLE

                binding.btnAddToCart.animate()
                    .translationY(0f)
                    .setDuration(300)
                    .start()
            }

    }
}




class DetailViewModelFactory(
    private val repository: DetailProductRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

}