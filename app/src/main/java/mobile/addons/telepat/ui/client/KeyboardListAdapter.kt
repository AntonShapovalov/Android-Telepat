package mobile.addons.telepat.ui.client

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_guess.view.*
import kotlinx.android.synthetic.main.list_item_key.view.*
import mobile.addons.telepat.R

/**
 * Recycler adapter for Keyboard, used in [ClientFragment]
 */
class KeyboardListAdapter(private val onKeyClick: (value: Int) -> Unit) : RecyclerView.Adapter<KeyboardListAdapter.KeyViewHolder>() {

    companion object {
        const val REMOVE_CODE = -1
        const val GUESS_CODE = -100
    }

    private val items = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, REMOVE_CODE, 0, GUESS_CODE)

    override fun getItemViewType(position: Int): Int = if (items[position] == GUESS_CODE) GUESS_CODE else 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyViewHolder {
        val id = if (viewType == GUESS_CODE) R.layout.list_item_guess else R.layout.list_item_key
        val v = LayoutInflater.from(parent.context).inflate(id, parent, false)
        return KeyViewHolder(v)
    }

    override fun onBindViewHolder(holder: KeyViewHolder, position: Int) {
        val view = if (holder.itemViewType == GUESS_CODE) holder.itemView.buttonGuess else holder.itemView.buttonKey
        val value = items[position]
        view.text = when (value) {
            REMOVE_CODE -> "C"
            GUESS_CODE -> "?"
            else -> value.toString()
        }
        view.setOnClickListener { onKeyClick(value) }
    }

    override fun getItemCount() = items.size

    class KeyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}