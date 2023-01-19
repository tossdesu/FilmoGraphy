package com.tossdesu.filmography.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.BottomDialogLayoutBinding

class FilmInfoDialogFragment : BottomSheetDialogFragment() {

    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var dialogBehavior: BottomSheetBehavior<FrameLayout>

    private var dialogPeekHeight = DIALOG_PEEK_HEIGHT_DEFAULT

    private var _binding: BottomDialogLayoutBinding? = null
    private val binding: BottomDialogLayoutBinding
        get() = _binding ?: throw RuntimeException("BottomDialogLayoutBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsParams()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnKeyListener { _, keyCode, keyEvent ->
                if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.action == KeyEvent.ACTION_UP) {
                    this@FilmInfoDialogFragment.bottomSheetDialog.dismiss()
                    returnToFilmRequestSourceFragment()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
        }
    }

    override fun getTheme() = R.style.Theme_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomDialogLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetDialog = dialog as BottomSheetDialog
        dialogBehavior = bottomSheetDialog.behavior
        dialogBehavior.peekHeight = dialogPeekHeight
        setBottomSheetListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parsParams() {
        val args = requireArguments()
        if (!args.containsKey(DIALOG_PEEK_HEIGHT)) {
            throw RuntimeException("DIALOG_PEEK_HEIGHT extra param is absent")
        }
        dialogPeekHeight = args.getInt(DIALOG_PEEK_HEIGHT)
    }

    private fun setBottomSheetListener() {
        dialogBehavior.addBottomSheetCallback(object : BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> setLightStatusBar(false)
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        if (!getIsLightStatusBar()) setLightStatusBar(true)
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {}
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    BottomSheetBehavior.STATE_SETTLING -> {}
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (slideOffset > SLIDE_OFFSET_DEFAULT) {
                    val dimAmount =
                        if (slideOffset > SLIDE_OFFSET_MAX) SLIDE_OFFSET_MAX else slideOffset
                    bottomSheetDialog.window?.setDimAmount(dimAmount)
                } else {
                    if (slideOffset < SLIDE_OFFSET_MIN) {
                        bottomSheetDialog.dismiss()
                        returnToFilmRequestSourceFragment()
                    }
                }
            }
        })
    }

    private fun getInsetsController() = bottomSheetDialog.window?.let {
        WindowCompat.getInsetsController(it, requireActivity().window.decorView)
    }

    private fun getIsLightStatusBar() = getInsetsController()?.isAppearanceLightStatusBars ?: false

    private fun setLightStatusBar(isLight: Boolean) {
        getInsetsController()?.isAppearanceLightStatusBars = isLight
    }

    private fun returnToFilmRequestSourceFragment() {
        requireActivity().supportFragmentManager.popBackStack(
            FilmPosterFragment.NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    companion object {

        private const val SLIDE_OFFSET_DEFAULT = 0.0f
        private const val SLIDE_OFFSET_MAX = 0.9f
        private const val SLIDE_OFFSET_MIN = -0.22f

        private const val DIALOG_PEEK_HEIGHT_DEFAULT = 0
        private const val DIALOG_PEEK_HEIGHT = "dialog_peek_height"

        fun newInstance(dialogPeekHeight: Int): FilmInfoDialogFragment {
            return FilmInfoDialogFragment().apply {
                arguments = Bundle().apply {
                        putInt(DIALOG_PEEK_HEIGHT, dialogPeekHeight)
                }
            }
        }
    }
}