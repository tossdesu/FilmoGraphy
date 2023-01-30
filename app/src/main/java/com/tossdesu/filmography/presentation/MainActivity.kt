package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.Fade
import androidx.transition.TransitionManager
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var accountFragment: AccountFragment
    @Inject
    lateinit var filmSelectionsFragment: FilmSelectionsFragment
    @Inject
    lateinit var searchFragment: SearchFragment

    private val component by lazy {
        (application as FilmoGraphyApp).component
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FilmoGraphy)
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        currentFragment = accountFragment

        setOnBottomNavBarSelectListener()
        setFilmInfoFragmentAttachListener()
        setFilmInfoFragmentDetachListener()
    }

    private fun setOnBottomNavBarSelectListener() {
        binding.bottomNavBar.setOnItemSelectedListener {
            val fragment = when(it.itemId) {
                R.id.accountFragment -> accountFragment
                R.id.filmsFragment -> filmSelectionsFragment
                R.id.searchFragment -> searchFragment
                else ->
                    throw RuntimeException("Have no fragment for bottomNavBar item ID = ${it.itemId}")
            }
            showFragment(fragment)
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            if (!fragment.isAdded) {
                add(R.id.bottomNavFragmentContainer, fragment)
            }
            if (currentFragment is SearchFragment) {
                detach(currentFragment)
            } else {
                hide(currentFragment)
            }
            if (fragment is SearchFragment) {
                attach(fragment)
            } else {
                show(fragment)
            }
            commit()
        }
        currentFragment = fragment
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