package ru.org.adons.telepat.ext

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Extensions for UI elements
 */

fun View.show() = let { visibility = View.VISIBLE }

fun View.hide() = let { visibility = View.INVISIBLE }

/**
 * Default recycler grid initialization
 *
 * @param adapter     recycler adapter
 * @param columnCount grid column count
 */
fun RecyclerView.initGrid(adapter: RecyclerView.Adapter<*>?, columnCount: Int) {
    layoutManager = GridLayoutManager(context, columnCount)
    if (adapter != null) this.adapter = adapter
    recycledViewPool.setMaxRecycledViews(0, columnCount * 3) // recycled count
}

