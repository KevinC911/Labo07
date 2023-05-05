package com.robles.labo05

import android.app.Application
import com.robles.labo05.data.movies
import com.robles.labo05.repository.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}