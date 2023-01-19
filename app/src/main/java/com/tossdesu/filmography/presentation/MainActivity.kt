package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.Fade
import androidx.transition.TransitionManager
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
        setTheme(R.style.Theme_FilmoGraphy)
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
                    throw RuntimeException("Have no fragment for bottomNavBar item ID = ${it.itemId}")
            }
            launchCurrentFragment(fragment)
            true
        }
    }

    private fun launchCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavFragmentContainer, fragment)
            .commit()
    }

    private fun setFilmInfoFragmentAttachListener() {
        supportFragmentManager.addFragmentOnAttachListener { _, fragment ->
            if (fragment is FilmPosterFragment) {
                binding.bottomNavBar.visibility = View.GONE
            }
        }
    }

    private fun setFilmInfoFragmentDetachListener() {
        supportFragmentManager.apply {
            addOnBackStackChangedListener {
                if (fragments[fragments.size - 1] !is FilmPosterFragment) {
                    val transition = Fade(Fade.IN)
                        .setDuration(350)
                        .addTarget(binding.bottomNavBar)
                        .setStartDelay(300)
                    TransitionManager.beginDelayedTransition(binding.root, transition)
                    binding.bottomNavBar.visibility = View.VISIBLE
                }
            }
        }
    }
}