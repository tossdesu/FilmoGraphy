package com.tossdesu.filmography.presentation.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration(
    private val dividerWidth: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        parent.adapter?.let { adapter ->
            parent.getChildAdapterPosition(view).let { position ->
                if (position == RecyclerView.NO_POSITION) return
                outRect.right = if (position == adapter.itemCount - 1) 0 else dividerWidth
            }
        }

    }
}