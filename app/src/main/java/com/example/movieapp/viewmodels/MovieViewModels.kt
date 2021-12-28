package com.example.movieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.connection.ApiConfig
import com.example.movieapp.connection.ApiService
import com.example.movieapp.models.Movie
import com.example.movieapp.models.MovieResponse
import com.example.movieapp.models.Tv
import com.example.movieapp.models.TvResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieViewModels: ViewModel() {
    val listPopular = MutableLiveData<List<MovieResponse>>()
    val listTv = MutableLiveData<List<MovieResponse>>()

    fun getMovieData(function: (List<MovieResponse>) -> Unit) {
        val apiService = ApiConfig.getInstance().create(ApiService::class.java)
        apiService.getPopularMovie().enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                return function(response.body()!!.items)
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getTvData(function: (List<TvResponse>) -> Unit) {
        val apiService = ApiConfig.getInstance().create(ApiService::class.java)
        apiService.getTv().enqueue(object : Callback<Tv> {
            override fun onResponse(call: Call<Tv>, response: Response<Tv>) {
                return function(response.body()!!.results)
            }

            override fun onFailure(call: Call<Tv>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getTopRatedMovie(function: (List<MovieResponse>) -> Unit) {
        val apiService = ApiConfig.getInstance().create(ApiService::class.java)
        apiService.getTopRatedMovie().enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                return function(response.body()!!.items)
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

}