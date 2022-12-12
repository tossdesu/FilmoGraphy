package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val navController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        initViewPagerAdapter()
        setupNavController()
        setNavControllerListener()
    }

    private fun setupNavController() {
        binding.bottomNavBar.setupWithNavController(
            navController = navController
        )
    }

    private fun setNavControllerListener() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id in arrayOf(
                    R.id.accountFragment,
                    R.id.filmsFragment,
                    R.id.searchFragment
                )) {
                binding.bottomNavBar.visibility = View.VISIBLE
                supportActionBar?.show()
            } else {
                binding.bottomNavBar.visibility = View.GONE
                supportActionBar?.hide()
            }
        }
    }



}