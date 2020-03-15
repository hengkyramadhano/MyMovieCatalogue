package com.example.mymoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.item_movies.img_photo
import kotlinx.android.synthetic.main.layout_description.*

class DetailMovie : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie

        description_title.text = movie.name
        description_body.text = movie.description
        genre_value.text = movie.genre
        duration_value.text = movie.duration
        director_value.text = movie.director
        rating_value.text = movie.rating
        img_photo.setImageResource(movie.photo)
    }
}
