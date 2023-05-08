package com.robles.labo05.ui.movies.billboard.recyclerview

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robles.labo05.data.model.MovieModel
import com.robles.labo05.databinding.MovieListBinding

class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel) -> Unit
) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<MovieModel>) {
        movies.clear()
        movies.addAll(moviesList)
    }
}