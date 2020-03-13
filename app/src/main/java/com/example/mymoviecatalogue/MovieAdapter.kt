package com.example.mymoviecatalogue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_movies.view.*


class MovieAdapter(private val listMovie: ArrayList<Movie>): RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    var listener: OnMovieListener? = null

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(movie.photo)
                    .into(img_photo)

                txt_name.text = movie.name
                txt_description.text = movie.description
                itemView.setOnClickListener {
                    listener?.onMovieItemClicked(movie)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_movies, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    interface OnMovieListener{
        fun onMovieItemClicked(data: Movie)
    }

}