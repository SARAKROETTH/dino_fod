package com.example.dinofood.feature.home.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.dinofood.R
import com.example.dinofood.databinding.ActivityBaseBinding
import com.example.dinofood.feature.FrameLayout.CartFragment
import com.example.dinofood.feature.FrameLayout.FavoriteFragment
import com.example.dinofood.feature.FrameLayout.HomeFragment
import com.example.dinofood.feature.FrameLayout.NotificationFragment
import com.example.dinofood.feature.FrameLayout.ProfileFragment

class BaseActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBaseBinding

    private val HomeFragment = HomeFragment()
    private  val  FavoriteFragment = FavoriteFragment()
    private  val  NotificationFragment = NotificationFragment()
    private  val  ProfileFragment = ProfileFragment()

    private val CartFragment = CartFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        replaceFragment(HomeFragment)

        binding.bottomNavigationBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment)
                R.id.cart -> replaceFragment(CartFragment)
                R.id.favorite -> replaceFragment(FavoriteFragment)
                R.id.notification -> replaceFragment(NotificationFragment)
                R.id.profile -> replaceFragment(ProfileFragment)
            }
            true
        }




    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}