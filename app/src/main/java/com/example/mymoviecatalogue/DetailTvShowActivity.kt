package com.example.mymoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val descName: TextView = findViewById(R.id.desc_title)
        val descBody: TextView = findViewById(R.id.desc_body)
        val genreValue: TextView = findViewById(R.id.genre_tvshow_value)
        val durationValue: TextView = findViewById(R.id.duration_tvshow_value)
        val seriesValue: TextView = findViewById(R.id.series_tvshow_value)
        val ratingValue: TextView = findViewById(R.id.rating_tvshow_value)
        val imagePoster: ImageView = findViewById(R.id.image_photo)

        val tvShow = intent.getParcelableExtra(EXTRA_TVSHOW) as TvShow

        descName.text = tvShow.name
        descBody.text = tvShow.description
        genreValue.text = tvShow.genre
        durationValue.text = tvShow.duration
        seriesValue.text = tvShow.series
        ratingValue.text = tvShow.rating
        imagePoster.setImageResource(tvShow.photo)
    }
}
