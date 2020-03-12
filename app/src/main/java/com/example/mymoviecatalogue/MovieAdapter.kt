package com.example.mymoviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var movies = arrayListOf<Movie>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movies, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    override fun getItem(i: Int): Any = movies[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = movies.size

    private inner class ViewHolder internal constructor(view: View){
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        internal fun bind(movie: Movie){
            txtName.text = movie.name
            txtDescription.text = movie.description
            imgPhoto.setImageResource(movie.photo)
        }
    }
}