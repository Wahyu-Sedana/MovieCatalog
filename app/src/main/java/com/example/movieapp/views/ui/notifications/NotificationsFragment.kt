package com.example.movieapp.views.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.databinding.FragmentNotificationsBinding
import com.example.movieapp.models.MovieResponse
import com.example.movieapp.viewmodels.MovieViewModels

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private lateinit var mainModel: MovieViewModels

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentNotificationsBinding.bind(view)
        mainModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MovieViewModels::class.java)
        binding.apply {
            rvViewTop.layoutManager = LinearLayoutManager(activity)
            rvViewTop.setHasFixedSize(true)
            mainModel.getTopRatedMovie { movies : List<MovieResponse> ->
                rvViewTop.adapter = MovieAdapter(movies)
            }
        }

    }
}