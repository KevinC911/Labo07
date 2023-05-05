package com.robles.labo05.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.robles.labo05.R
import com.robles.labo05.databinding.FragmentFirstBinding

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
    private lateinit var StarWars: LinearLayout
    private lateinit var HarryPotter: LinearLayout
    private lateinit var Button: FloatingActionButton
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        StarWars.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        HarryPotter.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_fourthFragment2)
        }
        Button.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
    }

    private fun bind() {
        StarWars = view?.findViewById(R.id.star_wars) as LinearLayout
        HarryPotter = view?.findViewById(R.id.harry_potter) as LinearLayout
        Button = view?.findViewById(R.id.add_a_movie) as FloatingActionButton
    }


}