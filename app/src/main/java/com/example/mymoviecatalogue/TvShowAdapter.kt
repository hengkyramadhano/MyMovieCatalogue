package com.example.mymoviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.view.*
import kotlinx.android.synthetic.main.item_tvshow.view.*

class TvShowAdapter(private val listTvShow: ArrayList<TvShow>): RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {

    var listener: OnTvShowListener? = null

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(tvshow: TvShow){
            with(itemView){
                Glide.with(itemView.context)
                    .load(tvshow.photo)
                    .into(poster_tvshow)

                txt_name.text = tvshow.name
                txt_description.text = tvshow.description

                itemView.setOnClickListener {
                    listener?.onTvShowItemClicked(tvshow)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_tvshow, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    interface OnTvShowListener{
        fun onTvShowItemClicked(data: TvShow)
    }
}