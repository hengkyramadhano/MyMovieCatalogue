package com.example.mymoviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(), TvShowAdapter.OnTvShowListener {

    private val list = ArrayList<TvShow>()

    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataSeries: Array<String>
    private lateinit var dataRating: Array<String>
    private lateinit var dataPhoto: TypedArray

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_tvshow.setHasFixedSize(true)

        list.addAll(getListTvShow())
        showRecyclerList()
    }

    private fun getListTvShow(): ArrayList<TvShow> {
        dataName = resources.getStringArray(R.array.data_name_tvshow)
        dataDescription = resources.getStringArray(R.array.data_description_tvshow)
        dataPhoto = resources.obtainTypedArray(R.array.data_poster_tvshow)
        dataGenre = resources.getStringArray(R.array.data_genre_tvshow)
        dataDuration = resources.getStringArray(R.array.data_duration_tvshow)
        dataSeries = resources.getStringArray(R.array.data_series_tvshow)
        dataRating = resources.getStringArray(R.array.data_rating_tvshow)

        val listTvShow = ArrayList<TvShow>()
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
            listTvShow.add(tvshow)
        }
        return listTvShow
    }
    private fun showRecyclerList() {
        rv_tvshow.layoutManager = LinearLayoutManager(requireContext())
        val listTvShowAdapter = TvShowAdapter(list)
        listTvShowAdapter.listener = this
        rv_tvshow.adapter = listTvShowAdapter
    }

    override fun onTvShowItemClicked(data: TvShow) {
        val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, data)
        startActivity(intent)
    }
}
