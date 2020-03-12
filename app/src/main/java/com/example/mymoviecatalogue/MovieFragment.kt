package com.example.mymoviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), View.OnClickListener {

    private lateinit var adapter: MovieAdapter

    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataDirector: Array<String>
    private lateinit var dataRating: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = MovieAdapter(requireContext())
        lv_movie.adapter = adapter

        prepare()
        addItem()

        lv_movie.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val listDataMovie = Movie(0,"","","","","","")
            listDataMovie.photo = dataPhoto.getResourceId(position, position)
            listDataMovie.name = dataName[position]
            listDataMovie.description = dataDescription[position]
            listDataMovie.genre = dataGenre[position]
            listDataMovie.duration = dataDuration[position]
            listDataMovie.director = dataDirector[position]
            listDataMovie.rating = dataRating[position]


            val intent = Intent(activity, DetailMovie::class.java)
            intent.putExtra(DetailMovie.EXTRA_MOVIE, listDataMovie)

            this@MovieFragment.startActivity(intent)
            Toast.makeText(activity, movies[position].name, Toast.LENGTH_SHORT).show()
        }
//        context?.let {context ->
//
//        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataGenre = resources.getStringArray(R.array.data_genre)
        dataDuration = resources.getStringArray(R.array.data_duration)
        dataDirector = resources.getStringArray(R.array.data_director)
        dataRating = resources.getStringArray(R.array.data_rating)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position],
                dataGenre[position],
                dataDuration[position],
                dataDirector[position],
                dataRating[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }

    override fun onClick(v: View?) {

    }

}
