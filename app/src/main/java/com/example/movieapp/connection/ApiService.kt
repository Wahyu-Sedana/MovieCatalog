package com.example.movieapp.connection

import com.example.movieapp.models.Movie
import com.example.movieapp.models.Tv
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/popular?api_key=ed011b93010134fa021943daf381771d")
    fun getPopularMovie(): Call<Movie>

    @GET("/3/movie/top_rated?api_key=ed011b93010134fa021943daf381771d")
    fun getTopRatedMovie(): Call<Movie>

    @GET("/3/tv/popular?api_key=ed011b93010134fa021943daf381771d")
    fun getTv(): Call<Tv>
}