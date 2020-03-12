package com.example.mymoviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class TvShowAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var tvshows = arrayListOf<TvShow>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_tvshow, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val tvshow = getItem(position) as TvShow
        viewHolder.bind(tvshow)
        return itemView
    }

    override fun getItem(position: Int): Any = tvshows[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = tvshows.size

    private inner class ViewHolder internal constructor(view: View){
        private val textName: TextView = view.findViewById(R.id.txt_name)
        private val textDescription: TextView = view.findViewById(R.id.txt_description)
        private val imagePoster: ImageView = view.findViewById(R.id.poster_tvshow)

        internal fun bind(tvshow: TvShow){
            textName.text = tvshow.name
            textDescription.text = tvshow.description
            imagePoster.setImageResource(tvshow.photo)
        }
    }
}