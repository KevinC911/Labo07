package com.robles.labo05.ui.movies.billboard.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.robles.labo05.data.model.MovieModel
import com.robles.labo05.databinding.MovieListBinding

class MovieRecyclerViewHolder(private val binding: MovieListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleText.text = movie.name
        binding.calificationText.text = movie.qualification

        binding.starWars.setOnClickListener{
            clickListener(movie)
        }
    }
}