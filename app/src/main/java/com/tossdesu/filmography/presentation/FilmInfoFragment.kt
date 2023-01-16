package com.tossdesu.filmography.presentation

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.google.android.material.transition.MaterialContainerTransform
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentFilmInfoBinding

class FilmInfoFragment : Fragment() {

    private var _binding: FragmentFilmInfoBinding? = null
    private val binding: FragmentFilmInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentFilmInfoBinding = null")

    private var imageResId: Int = IMG_RES_ID_EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parsParams()

        val inflater = TransitionInflater.from(requireContext())
        returnTransition = inflater.inflateTransition(R.transition.fade)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = ENTER_DURATION
            scrimColor = Color.TRANSPARENT
        }
        sharedElementReturnTransition = MaterialContainerTransform().apply {
            duration = RETURN_DURATION
            scrimColor = Color.TRANSPARENT
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPosterImage()
        ViewCompat.setTransitionName(binding.ivPoster, imageResId.toString())
        val dialogPeekHeight = calculateDialogPeekHeight()
        launchBottomDialogFragment(dialogPeekHeight)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parsParams() {
        val args = requireArguments()
        if (!args.containsKey(IMG_RES_ID)) {
            throw RuntimeException("IMG_RES_ID extra param is absent")
        }
        imageResId = args.getInt(IMG_RES_ID)
    }

    private fun setPosterImage() {
        binding.ivPoster.setImageResource(imageResId)
        binding.ivPoster.layoutParams.width = getPosterWidth()
        binding.ivPoster.requestLayout()
    }

    private fun getPosterWidth(): Int {
        val displayWidth = Resources.getSystem().displayMetrics.widthPixels
        return (displayWidth * (POSTER_IMG_WIDTH_PERCENT / 100)).toInt()
    }

    private fun calculateDialogPeekHeight(): Int {
        val imgWidth = binding.ivPoster.layoutParams.width
        val imgHeight = imgWidth / 2 * 3
        val displayHeight = Resources.getSystem().displayMetrics.heightPixels
        return displayHeight - (imgHeight + POSTER_IMG_BOTTOM_MARGIN)
    }

    private fun launchBottomDialogFragment(dialogPeekHeight: Int) {
        BottomDialogFilmInfoFragment
            .newInstance(dialogPeekHeight)
            .show(requireActivity().supportFragmentManager, DIALOG_TAG)
    }

    companion object {
        const val NAME = "film_info_fragment"
        private const val IMG_RES_ID = "img_res_id"
        private const val IMG_RES_ID_EMPTY = 0
        private const val DIALOG_TAG = "bottom_sheet_dialog"
        private const val ENTER_DURATION = 350L
        private const val RETURN_DURATION = 350L
        private const val POSTER_IMG_WIDTH_PERCENT = 65.0
        private const val POSTER_IMG_BOTTOM_MARGIN = 120

        fun newInstance(imageResId: Int): FilmInfoFragment {
            return FilmInfoFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMG_RES_ID, imageResId)
                }
            }
        }
    }
}