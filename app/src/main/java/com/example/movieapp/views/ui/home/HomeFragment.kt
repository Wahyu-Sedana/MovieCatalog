package com.example.movieapp.views.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.models.MovieResponse
import com.example.movieapp.viewmodels.MovieViewModels

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private lateinit var mainModel: MovieViewModels

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)
        mainModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MovieViewModels::class.java)
       binding.apply {
           rvView.layoutManager = LinearLayoutManager(activity)
           rvView.setHasFixedSize(true)
           mainModel.getMovieData { movies : List<MovieResponse> ->
               rvView.adapter = MovieAdapter(movies)
           }
       }

    }
}