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
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment(), View.OnClickListener {

    private lateinit var adapter: TvShowAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataSeries: Array<String>
    private lateinit var dataRating: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var tvshows = ArrayList<TvShow>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = TvShowAdapter(requireContext())
        lv_tv_show.adapter = adapter

        prepare()
        addItem()

        lv_tv_show.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val listDataTvShow = TvShow(0, "", "", "", "", "", "")
            listDataTvShow.photo = dataPhoto.getResourceId(position, position)
            listDataTvShow.name = dataName[position]
            listDataTvShow.description = dataDescription[position]
            listDataTvShow.genre = dataGenre[position]
            listDataTvShow.duration = dataDuration[position]
            listDataTvShow.series = dataSeries[position]
            listDataTvShow.rating = dataRating[position]

            val moveActivity = Intent(activity, DetailTvShowActivity::class.java)
            moveActivity.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, listDataTvShow)

            this@TvShowFragment.startActivity(moveActivity)
            Toast.makeText(activity, tvshows[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name_tvshow)
        dataDescription = resources.getStringArray(R.array.data_description_tvshow)
        dataPhoto = resources.obtainTypedArray(R.array.data_poster_tvshow)
        dataGenre = resources.getStringArray(R.array.data_genre_tvshow)
        dataDuration = resources.getStringArray(R.array.data_duration_tvshow)
        dataSeries = resources.getStringArray(R.array.data_series_tvshow)
        dataRating = resources.getStringArray(R.array.data_rating_tvshow)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val tvshow = TvShow(
                dataPhoto.getResourceId(position,-1),
                dataName[position],
                dataDescription[position],
                dataGenre[position],
                dataDuration[position],
                dataSeries[position],
                dataRating[position]
            )
            tvshows.add(tvshow)
        }
        adapter.tvshows = tvshows
    }

    override fun onClick(v: View?) {
    }

}
