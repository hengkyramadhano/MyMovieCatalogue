package com.example.mymoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val tvShow = intent.getParcelableExtra(EXTRA_TVSHOW) as TvShow

        desc_title.text = tvShow.name
        desc_body.text = tvShow.description
        genre_tvshow_value.text = tvShow.genre
        duration_tvshow_value.text = tvShow.duration
        series_tvshow_value.text = tvShow.series
        rating_tvshow_value.text = tvShow.rating
        image_photo.setImageResource(tvShow.photo)
    }
}
