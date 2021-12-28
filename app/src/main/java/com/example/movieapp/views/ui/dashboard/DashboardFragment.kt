package com.example.movieapp.views.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.adapters.TvAdapter
import com.example.movieapp.databinding.FragmentDashboardBinding
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.models.MovieResponse
import com.example.movieapp.models.TvResponse
import com.example.movieapp.viewmodels.MovieViewModels

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TvAdapter
    private lateinit var mainModel: MovieViewModels

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDashboardBinding.bind(view)
        mainModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MovieViewModels::class.java)
        binding.apply {
            rvViewTv.layoutManager = LinearLayoutManager(activity)
            rvViewTv.setHasFixedSize(true)
            mainModel.getTvData { tvs : List<TvResponse> ->
                rvViewTv.adapter = TvAdapter(tvs)
            }
        }

    }
}