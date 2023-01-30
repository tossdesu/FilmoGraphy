package com.tossdesu.filmography.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentFilmSelectionsBinding
import com.tossdesu.filmography.presentation.adapter.DividerItemDecoration
import com.tossdesu.filmography.presentation.adapter.FilmsAdapter
import com.tossdesu.filmography.presentation.adapter.FilmsBigAdapter
import javax.inject.Inject

class FilmSelectionsFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var filmsPopularAdapter: FilmsBigAdapter
    @Inject
    lateinit var filmsTop250Adapter: FilmsAdapter
    @Inject
    lateinit var filmsPremiereAdapter: FilmsAdapter

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[FilmSelectionsViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as FilmoGraphyApp).component
    }

    private var _binding: FragmentFilmSelectionsBinding? = null
    private val binding: FragmentFilmSelectionsBinding
        get() = _binding ?: throw RuntimeException("FragmentFilmSelectionsBinding = null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeRefresher()
        initAdapters()
        setupOnCLickListeners()
        observeViewModel()
        loadFilmSelections()

//        ViewCompat.setTransitionName(binding.ivPoster1, binding.ivPoster1.id.toString())
//        binding.ivPoster1.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_1) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupSwipeRefresher() {
        binding.srFilmSelectionsRefresher.apply {
            setColorSchemeResources(R.color.blue_300)
            setOnRefreshListener {
                loadFilmSelections()
            }
        }
    }

    private fun initAdapters() {
        val itemDivider = DividerItemDecoration(RV_ITEM_DIVIDER_WIDTH)
        binding.rvPopularFilms.apply {
            adapter = filmsPopularAdapter
            addItemDecoration(itemDivider)
        }
        binding.rvAwaitFilms.apply {
            adapter = filmsTop250Adapter
            addItemDecoration(itemDivider)
        }
        binding.rvPremiereFilms.apply {
            adapter = filmsPremiereAdapter
            addItemDecoration(itemDivider)
        }
    }

    private fun setupOnCLickListeners() {
        filmsPopularAdapter.setOnClickListener = {
            // TODO: Launch FilmPosterFragment with Transition for image
        }
    }

    private fun observeViewModel() {
        viewModel.state.observe(viewLifecycleOwner) {
            binding.srFilmSelectionsRefresher.isRefreshing = false
            binding.llFilmsSelections.visibility = View.VISIBLE
            when (it) {
                is Error -> {}
                is Progress -> {
                    binding.srFilmSelectionsRefresher.isRefreshing = true
                    binding.llFilmsSelections.visibility = View.INVISIBLE
                }
                is ResponseFilmsData -> {
                    filmsPopularAdapter.submitList(it.popular)
                    filmsTop250Adapter.submitList(it.awaited)
                    filmsPremiereAdapter.submitList(it.premiere)
                }
            }
        }
    }

    private fun loadFilmSelections() {
        viewModel.getFilmSelections()
    }

    private fun launchFilmPosterFragment(posterView: View, imageResId: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .addSharedElement(posterView, imageResId.toString())
            .replace(R.id.bottomNavFragmentContainer, FilmPosterFragment.newInstance(imageResId))
            .addToBackStack(FilmPosterFragment.NAME)
            .commit()
    }

    companion object {

        private const val RV_ITEM_DIVIDER_WIDTH = 50
    }
}