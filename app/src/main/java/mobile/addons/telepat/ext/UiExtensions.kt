package mobile.addons.telepat.ext

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

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

