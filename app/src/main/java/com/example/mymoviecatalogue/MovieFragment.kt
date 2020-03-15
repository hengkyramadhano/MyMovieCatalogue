package com.example.mymoviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(), MovieAdapter.OnMovieListener {

    private val list = ArrayList<Movie>()

    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataDirector: Array<String>
    private lateinit var dataRating: Array<String>
    private lateinit var dataPhoto: TypedArray

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movie.setHasFixedSize(true)

        list.addAll(getListMovie())
        showRecyclerList()
    }

    private fun getListMovie(): ArrayList<Movie> {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataGenre = resources.getStringArray(R.array.data_genre)
        dataDuration = resources.getStringArray(R.array.data_duration)
        dataDirector = resources.getStringArray(R.array.data_director)
        dataRating = resources.getStringArray(R.array.data_rating)

        val listMovie = ArrayList<Movie>()
        for (position in dataName.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position,-1),
                dataName[position],
                dataDescription[position],
                dataGenre[position],
                dataDuration[position],
                dataDirector[position],
                dataRating[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rv_movie.layoutManager = LinearLayoutManager(requireContext())
        val listMovieAdapter = MovieAdapter(list)
        listMovieAdapter.listener = this
        rv_movie.adapter = listMovieAdapter
    }

    override fun onMovieItemClicked(data: Movie) {
        val intent = Intent(requireContext(), DetailMovie::class.java)
        intent.putExtra(DetailMovie.EXTRA_MOVIE, data)
        startActivity(intent)
    }
}
