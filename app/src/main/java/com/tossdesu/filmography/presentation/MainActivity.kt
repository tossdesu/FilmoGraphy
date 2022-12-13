package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val accountFragment = AccountFragment.newInstance()
    private val filmsFragment = FilmsFragment.newInstance()
    private val searchFragment = SearchFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnBottomNavBarSelectListener()
        setFilmInfoFragmentAttachListener()
        setFilmInfoFragmentDetachListener()
    }

    private fun setOnBottomNavBarSelectListener() {
        binding.bottomNavBar.setOnItemSelectedListener {
            val fragment = when(it.itemId) {
                R.id.accountFragment -> accountFragment
                R.id.filmsFragment -> filmsFragment
                R.id.searchFragment -> searchFragment
                else ->
                    throw RuntimeException("Have no fragment for bottomNavBar item id = ${it.itemId}")
            }
            launchCurrentFragment(fragment)
            true
        }
    }

    private fun setFilmInfoFragmentAttachListener() {
        supportFragmentManager.addFragmentOnAttachListener { _, fragment ->
            if (fragment is FilmInfoFragment) {
                binding.bottomNavBar.visibility = View.GONE
            }
        }
    }

    private fun setFilmInfoFragmentDetachListener() {
        supportFragmentManager.apply {
            addOnBackStackChangedListener {
                if (fragments[fragments.size-1] !is FilmInfoFragment) {
                    binding.bottomNavBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun launchCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavFragmentContainer, fragment)
            .commit()
    }
}