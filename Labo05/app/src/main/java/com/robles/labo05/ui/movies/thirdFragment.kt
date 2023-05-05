package com.robles.labo05.ui.movies

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.robles.labo05.R
import com.robles.labo05.data.model.MovieModel
import com.robles.labo05.databinding.FragmentThirdBinding

class thirdFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels{ MovieViewModel.Factory }
    private lateinit var nameInput: EditText
    private lateinit var categoryInput: EditText
    private lateinit var descriptionInput: EditText
    private lateinit var qualificationInput: EditText
    private lateinit var buttonAddMovie: Button
    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        listeners()
    }

    private fun listeners(){
        buttonAddMovie.setOnClickListener{
            viewModel.addMovies(
                MovieModel(nameInput.text.toString(),
            categoryInput.text.toString(),
            descriptionInput.text.toString(),
            qualificationInput.text.toString())
            )
        }
        Log.d("movies", viewModel.getMovies().toString())
    }

    private fun bind(view: View) {
        nameInput = view.findViewById(R.id.name_input)
        categoryInput = view.findViewById(R.id.category_input)
        descriptionInput = view.findViewById(R.id.description_input)
        qualificationInput = view.findViewById(R.id.calification_input)
        buttonAddMovie = view.findViewById(R.id.add_movie)
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) {status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    viewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, viewModel.getMovies().toString())
                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }

            }
        }



}