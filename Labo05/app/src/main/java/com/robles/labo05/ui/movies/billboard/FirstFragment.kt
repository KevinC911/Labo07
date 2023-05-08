package com.robles.labo05.ui.movies.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.robles.labo05.R
import com.robles.labo05.data.model.MovieModel
import com.robles.labo05.databinding.FragmentFirstBinding
import com.robles.labo05.ui.movies.billboard.recyclerview.MovieRecyclerViewAdapter
import com.robles.labo05.ui.movies.viewmodel.MovieViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class  FirstFragment : Fragment() {
    private lateinit var Button: FloatingActionButton
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: MovieRecyclerViewAdapter
    private val viewModel: MovieViewModel by viewModels{ MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setRecyclerView(view)

        binding.addAMovie.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
    }

    private fun showSelectedItem(movie: MovieModel) {
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }

    private fun displayMovies() {
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }


}