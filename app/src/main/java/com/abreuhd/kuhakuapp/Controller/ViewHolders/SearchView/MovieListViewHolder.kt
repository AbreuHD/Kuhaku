package com.abreuhd.kuhakuapp.Controller.ViewHolders.SearchView

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abreuhd.kuhakuapp.Model.Movies.MoviePreview
import com.abreuhd.kuhakuapp.databinding.ItemSearchviewBinding
import com.squareup.picasso.Picasso

class MovieListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSearchviewBinding.bind(view)

    fun bind(movieListItemResponse: MoviePreview, onItemSelected: (Long) -> Unit) {
        binding.tvTitleMovieSearch.text = movieListItemResponse.title
        Log.i("img", "https://image.tmdb.org/t/p/w200/${movieListItemResponse.posterPath}")
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w200/${movieListItemResponse.posterPath}")
            .into(binding.ivMovieSearch)

        binding.tvStarsMovieSearch.text = "${movieListItemResponse.voteAverage.toInt().toString()}/10 ⭐"
        binding.tvDateMovieSearch.text = "Estreno: ${movieListItemResponse.releaseDate}"


        val description = movieListItemResponse.overview
        if (description.length >= 120) {
            val truncatedDescription = movieListItemResponse.overview.subSequence(0, 120)
            binding.tvDescriptionMovieSearch.text = "${truncatedDescription}..."
        } else {
            binding.tvDescriptionMovieSearch.text = "${description}..."
        }

        binding.root.setOnClickListener {
            onItemSelected(movieListItemResponse.id)
        }
    }
}