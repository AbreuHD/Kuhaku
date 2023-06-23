package com.abreuhd.kuhakuapp.Controller.Adapters.SearchView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abreuhd.kuhakuapp.Controller.ViewHolders.SearchView.MovieListViewHolder
import com.abreuhd.kuhakuapp.Model.Movies.MovieList
import com.abreuhd.kuhakuapp.R

class SearchViewAdapter(
    var movieList: List<MovieList> = emptyList(),
    private val onItemSelected: (Long) -> Unit
) : RecyclerView.Adapter<MovieListViewHolder>() {

    fun onUpdateList(movieList: List<MovieList>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieListViewHolder(layoutInflater.inflate(R.layout.item_searchview, parent, false))
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(viewHolder: MovieListViewHolder, position: Int) {
        viewHolder.bind(movieList[position], onItemSelected)
    }

}